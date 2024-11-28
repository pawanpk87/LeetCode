class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dist = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;        
            }
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        
        dist[0][0] = grid[0][0];
        minHeap.add(new int[]{dist[0][0], 0, 0});
        
        while(!minHeap.isEmpty()) {
            int[] u = minHeap.poll();
            
            int currDist = u[0];
            int i = u[1], j = u[2];
            
            if(i == n - 1 && j == m - 1) {
                return currDist;
            }
            
            for(int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                
                if(isValid(ni, nj, n, m)) {
                    int nextDist = currDist + grid[ni][nj];
                    
                    if(dist[ni][nj] > nextDist) {
                        dist[ni][nj] = nextDist;
                        minHeap.add(new int[]{nextDist, ni, nj});
                    }
                }
            }
        }
        
        return dist[n - 1][m - 1];
    }
    
    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}