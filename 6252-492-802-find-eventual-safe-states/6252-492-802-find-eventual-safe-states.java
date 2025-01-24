class Solution {
	public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> safeNodes = new ArrayList<>();

        List<List<Integer>> adjList = createAdjList(graph);	

        int[] isSafe = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(isSafe, -1);
        Arrays.fill(visited, false);

        for(int node = 0; node < n; node++) {
            if(!visited[node]) {
                markSafeNodes(node, isSafe, visited, adjList);
            }
            if(isSafe[node] == 1 || adjList.get(node).size() == 0) {
              safeNodes.add(node);
            }
		}
    
		return safeNodes;
	}

	private boolean markSafeNodes(int currNode, int[] isSafe, boolean[] visited, List<List<Integer>> adjList) {
		if(isSafe[currNode] != -1) {
			return isSafe[currNode] == 1 ? true: false;
		}
        
        if(adjList.get(currNode).size() == 0) {
			return true;
		}
		
		if(visited[currNode]) {
			return false;
		}
		
		visited[currNode] = true;

		boolean safe = true;

		for(int adjNode : adjList.get(currNode)) {
			safe = safe && markSafeNodes(adjNode, isSafe, visited, adjList);
		}
        
		isSafe[currNode] = safe ? 1 : 0;
		
		return safe;
	}

	private List<List<Integer>> createAdjList(int[][] graph) {
		int n = graph.length;

		List<List<Integer>> adjList = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		
        for(int i = 0; i < n; i++) {	
            for(int adjNode : graph[i]) {
                adjList.get(i).add(adjNode);
            }	
        }

        return adjList;	
	}
}