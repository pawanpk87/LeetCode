class Solution {
    public static int[] dx = new int[] {1, -1, 0, 0};
    public static int[] dy = new int[] {0, 0, 1, -1};
    
    private boolean isSubIsland(int row, int col, int[][] grid1, int[][] grid2, int n, int m, boolean[][] visited) {
        boolean subIsland = true;
        
        if(grid1[row][col] == 0) {
            subIsland = false;
        }
        
        for(int k = 0; k < 4; k++) {
            int nrow = row + dx[k];
            int ncol = col + dy[k];
            if(isSafe(nrow, ncol, n, m) && !visited[nrow][ncol] && grid2[nrow][ncol] == 1) {
                visited[nrow][ncol] = true;
                subIsland = subIsland & isSubIsland(nrow, ncol, grid1, grid2, n, m, visited);
            }
        }
        
        return subIsland;
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid2[i][j] == 1 && visited[i][j] == false) {
                    visited[i][j] = true;
                    if(isSubIsland(i, j, grid1, grid2, n, m, visited)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean isSafe(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}