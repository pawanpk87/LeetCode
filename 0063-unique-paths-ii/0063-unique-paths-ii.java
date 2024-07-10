class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1){
            return 0;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        
        for(int j = 0; j < m; j++){
            if(obstacleGrid[0][j] == -1){
                break;
            }
            obstacleGrid[0][j] = 1;
        }
        
        for(int i = 0; i < n; i++){
            if(obstacleGrid[i][0] == -1){
                break;
            }
            obstacleGrid[i][0] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(obstacleGrid[i][j] == 0){
                    if(obstacleGrid[i-1][j] == -1 || obstacleGrid[i][j-1] == -1){
                        obstacleGrid[i][j] = Math.max(obstacleGrid[i-1][j], obstacleGrid[i][j-1]);
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                    }
                }
            }
        }        
        
        return Math.max(obstacleGrid[n-1][m-1], 0);
    }
}