class Solution {
    private int getSum(List<List<Integer>> adjList, int n) {
        Queue<Integer> bfs = new LinkedList<>();
        int[] dist = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bfs.add(0);
        dist[0] = 0;
        
        while(!bfs.isEmpty()) {
            int node = bfs.poll();
            for(int adjNode : adjList.get(node)) {
                if(dist[adjNode] > (dist[node] + 1)) {
                    dist[adjNode] = dist[node] + 1;
                    bfs.add(adjNode);
                }
            }
        }
        
        return dist[n-1];
    }
    
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 1; i < n; i++) {
            adjList.get(i-1).add(i);
        }
        
        int[] result = new int[queries.length];
        int index = 0;
        for(int[] q : queries) {
            adjList.get(q[0]).add(q[1]);
            int sum = getSum(adjList, n);
            result[index++] = sum;
        }
        
        return result;
    }
}