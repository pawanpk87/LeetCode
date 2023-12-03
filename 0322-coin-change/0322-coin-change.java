class Solution {
    private int memo[][];
    
    private int solve(int currIndex, int amount, int coins[], int n){
        if(amount == 0){
            return 0;
        }    
        
        if(currIndex == n){
            return Integer.MAX_VALUE;
        }
        
        if(memo[currIndex][amount] != -1){
            return memo[currIndex][amount];
        }
        
        if(coins[currIndex] <= amount){
            int opt1 = solve(currIndex, amount - coins[currIndex], coins, n);
            int opt2 = solve(currIndex + 1, amount, coins, n);
            return memo[currIndex][amount] = Math.min(opt1 == Integer.MAX_VALUE ? opt1 : 1 + opt1, opt2);
        }else{
            int opt1 = solve(currIndex + 1, amount, coins, n);
            return memo[currIndex][amount] = opt1;
        }
    }
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        memo = new int[n+1][amount+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(memo[i], -1);
        }
        
        int ans = solve(0, amount, coins, n);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}