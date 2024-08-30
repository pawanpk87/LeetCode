class Solution {
    private void dfs(int currNode, List<List<Integer>> adjList, Set<Integer> visited) {
        visited.add(currNode);
        for(Integer adjNode : adjList.get(currNode)) {
            if(!visited.contains(adjNode)) {
                dfs(adjNode, adjList, visited);
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int numComponents = 0;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1;  j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        Set<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i, adjList, visited);
                numComponents++;
            }
        }
        
        return n - numComponents;
    }
}