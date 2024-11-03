class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        
        int totalNumberOfPathCombinations = (int) Math.pow(2, n);
        int totalNumberOfNodes = n;
        
        int[][] minDistance = new int[totalNumberOfPathCombinations][totalNumberOfNodes];
        for(int i = 0; i < totalNumberOfPathCombinations; i++) {
            Arrays.fill(minDistance[i], -1);
        }
        
        Queue<int[]> bfs = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            int node = i;
            int visitedPath = setBit(0, i);
            
            bfs.add(new int[]{node, visitedPath});
            minDistance[visitedPath][node] = 0;
        }
        
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            while(size-- > 0) {
                int[] currNode = bfs.poll();
                
                int node = currNode[0];
                int path = currNode[1];
                
                if(path == totalNumberOfPathCombinations - 1) {
                    return minDistance[path][node];
                }
                
                for(int adjNode : graph[node]) {
                    int newPath = setBit(path, adjNode);
                    
                    if(minDistance[newPath][adjNode] != -1) {
                        continue;
                    }
                    
                    minDistance[newPath][adjNode] = minDistance[path][node] + 1;
                    bfs.add(new int[]{adjNode, newPath});
                }
            }
        }
        
        return -1;
    }
    
    private int setBit(int mask, int k) {
        return (mask | (1 << k));
    }
}