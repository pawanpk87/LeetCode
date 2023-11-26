class Solution {
    private int dfs(int grid[][], int i, int j, int n, int m){
        if(i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + (
                dfs(grid, i, j+1, n, m) +
                dfs(grid, i, j-1, n, m) +
                dfs(grid, i-1, j, n, m) +
                dfs(grid, i+1, j, n, m)
            );
        }else{
            return 0;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int maxArea = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j, n, m));
                }
            }
        }
        
        return maxArea;
    }
}