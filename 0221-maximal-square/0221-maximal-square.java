class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int maxSqr = 0;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    maxSqr = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(dp[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    maxSqr = Math.max(maxSqr, dp[i][j]);
                }
            }
        }
        
        return maxSqr * maxSqr;
    }
}
/*

[["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]]

[["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","2","2"],
 ["1","0","0","1","0"]]


 sqr(2, 2)
 


*/