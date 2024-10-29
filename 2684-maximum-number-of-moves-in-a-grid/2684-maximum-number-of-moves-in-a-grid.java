class Solution {
    int[] nr = new int[]{-1, 0, 1};
    int[] nc = new int[]{1, 1, 1};
    
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        
        
        for(int col = m-2; col >= 0; col--) {
            for(int row = 0; row < n; row++) {
                int maxLen = 0;

                int nrow, ncol;
                for(int k = 0; k < 3; k++) {
                    nrow = row + nr[k];
                    ncol = col + nc[k];
                    if(isValidMove(nrow, ncol, n, m) && 
                       grid[row][col] < grid[nrow][ncol]) {
                        maxLen = Math.max(maxLen, 1 + dp[nrow][ncol]);
                    }
                }

                dp[row][col] = maxLen;
            }
        }
        
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        
        return maxLen;
    }
    
    private boolean isValidMove(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}