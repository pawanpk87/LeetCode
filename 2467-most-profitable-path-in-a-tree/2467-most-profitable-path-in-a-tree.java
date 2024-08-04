class Solution {
    private void dfs(int node, int parentNode, int currDist, int[] parent, int[] dist, List<List<Integer>> adjList) {
        parent[node] = parentNode;
        dist[node] = currDist;
        for(int adjNode : adjList.get(node)) {
            if(adjNode != parentNode) {
                dfs(adjNode, node, currDist + 1, parent, dist, adjList);
            }
        }
    }
    
    private int dfs2(int node, int parent, int[] amount, List<List<Integer>> adjList) {
        int currAmount = amount[node];
        int maxAmount = Integer.MIN_VALUE;
        for(int adjNode : adjList.get(node)) {
            if(adjNode != parent) {
                maxAmount = Math.max(maxAmount, dfs2(adjNode, node, amount, adjList));
            }
        }
        if(maxAmount == Integer.MIN_VALUE) {
            return currAmount;
        }
        return currAmount + maxAmount;
    }
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        
        List<List<Integer>> adjList = buildAdjList(edges);
        
        int[] parent = new int[n];
        int[] dist = new int[n];
        
        dfs(0, -1, 0, parent, dist, adjList);
        
        int currNode = bob;
        int bobDist = 0;
        
        while(currNode != 0) {
            if(dist[currNode] > bobDist) {
                amount[currNode] = 0;
            } else if(dist[currNode] == bobDist) {
                amount[currNode] = amount[currNode]/2;
            }
            currNode = parent[currNode];
            bobDist++;
        }
        
        return dfs2(0, -1, amount, adjList);
    }
    
    private List<List<Integer>> buildAdjList(int[][] edges) {
        int n = edges.length + 1;
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int u,v;
        for(int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        return adjList;
    }
}