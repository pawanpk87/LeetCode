class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int dp[][] = new int[n+1][amount+1];
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j <= amount; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                    int opt1 = dp[i][j - coins[i-1]];
                    int opt2 = dp[i-1][j];
                    dp[i][j] = Math.min(opt1 == Integer.MAX_VALUE ? opt1 : 1 + opt1, opt2);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}