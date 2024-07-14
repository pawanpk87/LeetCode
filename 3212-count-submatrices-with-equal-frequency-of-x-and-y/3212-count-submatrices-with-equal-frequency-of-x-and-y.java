class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int[][] xFreq = getFreq(grid, 'X');
        int[][] yFreq = getFreq(grid, 'Y');
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(xFreq[i][j] == yFreq[i][j] && xFreq[i][j] > 0){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private int[][] getFreq(char[][] grid, char ch){
        int n = grid.length, m = grid[0].length;
        int[][] freq = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                freq[i][j] = grid[i][j] == ch ? 1 : 0;
                if(i > 0) freq[i][j] += freq[i-1][j];
                if(j > 0) freq[i][j] += freq[i][j-1];
                if(i > 0 && j > 0) freq[i][j] -= freq[i-1][j-1];
            }
        }
        return freq;
    }
}