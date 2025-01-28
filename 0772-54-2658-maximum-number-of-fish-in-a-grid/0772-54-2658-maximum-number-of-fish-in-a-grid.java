class Solution {
    private int dfs(int i, int j, int[][] grid, int n, int m) {
        if(!isValid(i, j, n, m) || grid[i][j] <= 0) {
            return 0;
        }

        int currWaterFish = grid[i][j];

        grid[i][j] = -1;

        return currWaterFish + (
            dfs(i, j + 1, grid, n, m) +
            dfs(i, j - 1, grid, n, m) + 
            dfs(i + 1, j, grid, n, m) + 
            dfs(i - 1, j, grid, n, m)
        );
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxFish = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(i, j, grid, n, m));
                }
            }
        }

        return maxFish;
    }
}