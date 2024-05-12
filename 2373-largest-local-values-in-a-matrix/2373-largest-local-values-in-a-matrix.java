class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n-2][n-2];
        for(int i = 1; i < (n-1); i++){
            for(int j = 1; j < (n-1); j++){
                int maxNum = getMaxNum(grid, i, j);
                result[i-1][j-1] = maxNum;
            }
        }
        return result;
    }
    
    public int getMaxNum(int[][] grid, int i, int j){
        int maxNum = grid[i-1][j-1];
        maxNum = Math.max(maxNum, grid[i-1][j]);
        maxNum = Math.max(maxNum, grid[i-1][j+1]);
        maxNum = Math.max(maxNum, grid[i][j-1]);
        maxNum = Math.max(maxNum, grid[i][j]);
        maxNum = Math.max(maxNum, grid[i][j+1]);
        maxNum = Math.max(maxNum, grid[i+1][j-1]);
        maxNum = Math.max(maxNum, grid[i+1][j]);
        maxNum = Math.max(maxNum, grid[i+1][j+1]);
        return maxNum;
    }
}