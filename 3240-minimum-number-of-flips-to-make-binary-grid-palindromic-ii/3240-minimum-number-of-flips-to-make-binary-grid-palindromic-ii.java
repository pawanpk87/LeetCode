class Solution {
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int totalFlips = 0;
        int totalOnes = 0;
        
        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < m/2; j++) {
                int ones = 0;
                if(grid[i][j] == 1) ones++;
                if(grid[i][(m-j-1)] == 1) ones++;
                if(grid[(n-1-i)][j] == 1) ones++;
                if(grid[(n-1-i)][(m-1-j)] == 1) ones++;
                if(ones == 4 || ones == 0) {
                    totalOnes += ones;
                } else if(ones >= 2) {
                    totalFlips += 4 - ones;
                    totalOnes += 4;
                } else {
                    totalFlips += ones;
                }
            }
        }
        
        if(n%2 == 0 && m%2 == 0) {
            return totalFlips;
        }
        
        int palindromOnes = 0;
        int oneschanges = 0;
        
        if(m%2 != 0) {
            for(int i = 0; i < n/2; i++) {
                if(grid[i][m/2] == 1 && grid[(n-1-i)][m/2] == 1){
                    palindromOnes++;
                }
                if(grid[i][m/2] != grid[(n-1-i)][m/2]){
                    totalFlips++;
                    oneschanges++;
                }
            }    
        }
        
        if(n%2 != 0) {
            for(int j = 0; j < m/2; j++) {
                if(grid[n/2][j] == 1 && grid[n/2][(m-1-j)] == 1){
                    palindromOnes++;
                }
                if(grid[n/2][j] != grid[n/2][(m-1-j)]){
                    totalFlips++;
                    oneschanges++;
                }
            }    
        }
        
        if(palindromOnes%2 != 0) {
            if(oneschanges == 0) {
                totalFlips+=2;
            }
        }
        
        if(n%2 != 0 && m%2 != 0 && grid[n/2][m/2] == 1){
            totalFlips++;
        }
        
        return totalFlips;
    }
}