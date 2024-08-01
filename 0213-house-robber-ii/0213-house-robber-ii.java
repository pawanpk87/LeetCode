class Solution {
    private int[] memo;
    
    private int solve(int currHouse, int[] nums, int n){
        int[] dp = new int[n+1];

        dp[0] = currHouse == 1 ? 0 : nums[0];
        dp[1] = nums[1];
        
        for(int i = currHouse + 1; i < n; i++) {
            dp[i] = Math.max(nums[i] + (i > 1 ? dp[i-2] : 0), dp[i-1]);
        }
        
        return dp[n-1];
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1) {
            return nums[0];
        }
        
        int pos2 = solve(1, nums, n);
        int pos1 = solve(0, nums, n-1);
        
        return Math.max(pos1, pos2);
    }
}