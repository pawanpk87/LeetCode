class Solution {
    private int[][] memo;
    
    int[] nr = new int[]{-1, 0, 1};
    int[] nc = new int[]{1, 1, 1};
        
    private int calMaxLen(int row, int col, int[][] grid, int rows, int cols) {
        if(memo[row][col] != -1) {
            return memo[row][col];
        }
        
        int maxLen = 0;
        
        int nrow, ncol;
        for(int k = 0; k < 3; k++) {
            nrow = row + nr[k];
            ncol = col + nc[k];
            if(isValidMove(nrow, ncol, rows, cols) && 
               grid[row][col] < grid[nrow][ncol]) {
                maxLen = Math.max(maxLen, 1 + calMaxLen(nrow, ncol, grid, rows, cols));
            }
        }
        
        return memo[row][col] = maxLen;
    }
    
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        int maxLen = 0;
        
        for(int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, calMaxLen(i, 0, grid, n, m));
        }
        
        return maxLen;
    }
    
    private boolean isValidMove(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}