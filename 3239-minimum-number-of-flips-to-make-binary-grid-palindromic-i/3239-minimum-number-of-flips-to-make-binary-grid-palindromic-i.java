class Solution {
    private int countRow(int[][] grid, int row) {
        int m = grid[0].length;
        int count = 0;
        int i = 0, j = m-1;
        while(i < j) {
            if(grid[row][i] != grid[row][j]) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
    
    private int countCol(int[][] grid, int col) {
        int n = grid.length;
        int count = 0;
        int i = 0, j = n-1;
        while(i < j) {
            if(grid[i][col] != grid[j][col]) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
    
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int totalRowCount = 0;
        int totalColCount = 0;
        
        for(int i = 0; i < n; i++) {
            totalRowCount += countRow(grid, i);
        }
        
        for(int j = 0; j < m; j++){
            totalColCount += countCol(grid, j);
        }
        
        return Math.min(totalRowCount, totalColCount);
    }
}