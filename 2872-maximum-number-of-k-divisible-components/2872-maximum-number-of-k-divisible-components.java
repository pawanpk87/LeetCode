class Solution {
    private int component;
    
    private int dfs(int currNode, int parentNode, List<List<Integer>> adjList, int[] values, int k) {
        int sum = 0;
        
        for(int adjNode : adjList.get(currNode)) {
            if(adjNode != parentNode) {
                sum += dfs(adjNode, currNode, adjList, values, k);
                sum = sum % k;
            }
        }
        
        sum += values[currNode];
        sum = sum % k;
        
        if(sum == 0) {
            component++;
        }
        
        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int u, v;
        for(int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        dfs(0, -1, adjList, values, k);
        
        return component;
    }
}