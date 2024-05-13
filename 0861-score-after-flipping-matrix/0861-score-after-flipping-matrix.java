class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 0){
                flipRow(grid, i);
            }
        } 
        
        int[] colOnes = new int[m];
        Arrays.fill(colOnes, 0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    colOnes[j]++;
                }
            }
        }
        
        for(int j = 0; j < m; j++){
            if(colOnes[j] > (n - colOnes[j])){
                flipCol(grid, j);
            }
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            StringBuilder binaryNum = new StringBuilder();
            for(int j = 0; j < m; j++){
                binaryNum.append(grid[i][j] == 0 ? '0' : '1');
            }
            sum += Integer.parseInt(binaryNum.toString(), 2);
        }
        
        return sum;
    }
    
    public void flipRow(int[][] grid, int row){
        int m = grid[0].length;
        for(int j = 0; j < m; j++){
            grid[row][j] = 1 - grid[row][j];
        }
    }
    
    public void flipCol(int[][] grid, int col){
        int n = grid.length;
        for(int i = 0; i < n; i++){
            grid[i][col] = 1 - grid[i][col];
        }
    }
}