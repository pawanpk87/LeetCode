class Solution {
    public static final int RED = 0;
    public static final int BLUE = 1;
    
    private int[] shortestAlternatingPathsUsingBFS(List<List<int[]>> adjList) {
        int n = adjList.size();

        int[][] dist = new int[n][2];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> bfs = new LinkedList<>();

        bfs.add(new int[]{0, RED});
        bfs.add(new int[]{0, BLUE});
        dist[0][RED] = 0;
        dist[0][BLUE] = 0;

        while(!bfs.isEmpty()) {
            int size = bfs.size();
            while(size-- > 0) {
                int[] currNode_ = bfs.poll();
                
                int currNode = currNode_[0];
                int currColor = currNode_[1];

                for(int[] adjNode_ : adjList.get(currNode)) {
                    int adjNode = adjNode_[0];
                    int adjColor = adjNode_[1];

                    if(currColor != adjColor && dist[adjNode][adjColor] == -1) {
                        dist[adjNode][adjColor] = dist[currNode][currColor] + 1;
                        bfs.add(new int[]{adjNode, adjColor});
                    }
                }
            }
        }

        int[] minDist = new int[n];
        for(int i = 0; i < n; i++) {
            if(dist[i][0] == -1 || dist[i][1] == -1) {
                minDist[i] = Math.max(dist[i][0], dist[i][1]);
            } else {
                minDist[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }

        return minDist;
    } 

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adjList = constructAdjList(n, redEdges, blueEdges);
        return shortestAlternatingPathsUsingBFS(adjList);
    }

    private List<List<int[]>> constructAdjList(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int u,v;
        for(int[] edge : redEdges) {
            u = edge[0]; v = edge[1];
            adjList.get(u).add(new int[]{v, RED});
        }
        for(int[] edge : blueEdges) {
            u = edge[0]; v = edge[1];
            adjList.get(u).add(new int[]{v, BLUE});
        }

        return adjList;
    }
}