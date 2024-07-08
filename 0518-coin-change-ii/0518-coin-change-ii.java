class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n + 1][amount + 1];
        
        dp[0][0] = 1;
        
        for(int j = 1; j <= amount; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= n; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        
        return dp[n][amount];
    }
}