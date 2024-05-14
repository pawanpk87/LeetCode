class Solution {
    private int getMaxGold(int i, int j, int[][] grid, int n, int m){
        if(i >= 0 && j >= 0 && i < n && j < m && grid[i][j] > 0){
            int tempNum = grid[i][j];
            
            grid[i][j] = -1;
            
            int L = getMaxGold(i, j-1, grid, n, m);
            int R = getMaxGold(i, j+1, grid, n, m);
            int U = getMaxGold(i-1, j, grid, n, m);
            int D = getMaxGold(i+1, j, grid, n, m);
            
            grid[i][j] = tempNum;
            
            return tempNum + Math.max(L, Math.max(R, Math.max(U, D)));
        } else{
            return 0;
        }
    }
    
    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int maxGold = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    maxGold = Math.max(maxGold, getMaxGold(i, j, grid, n, m));
                }
            }
        }
        
        return maxGold;
    }
}