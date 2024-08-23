class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for(int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + (int) s2.charAt(j-1);
        }
        
        for(int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + (int) s1.charAt(i-1);
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min((int) s1.charAt(i-1) + dp[i-1][j] ,
                                        (int) s2.charAt(j-1) + dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}