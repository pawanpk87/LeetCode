class Solution {
    int[][] memo;
    
    private boolean isValidMove(int row, int col, int n, int m){
        return row >= 0 && row < n &&
               col >= 0 && col < m;
    }
    
    private int solve(int currRow, int currCol, int[][] obstacleGrid, int n, int m){
        if(isValidMove(currRow, currCol, n, m) && obstacleGrid[currRow][currCol] == 0){
            if(currRow == n-1 && currCol == m-1){
                return 1;
            }
            
            if(memo[currRow][currCol] != -1){
                return memo[currRow][currCol];
            }
            
            int pos1 = solve(currRow, currCol + 1, obstacleGrid, n, m);
            int pos2 = solve(currRow + 1, currCol, obstacleGrid, n, m);
            
            return memo[currRow][currCol] = pos1 + pos2;
        } else {
            return 0;
        }
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        memo = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        
        return solve(0, 0, obstacleGrid, n, m);
    }
}