class Solution {
    private int totalSum;
    private int[][] memo;
    
    private int solve(int index, int currSum, int[] nums, int target) {
        if(index == nums.length) {
            return currSum == target ? 1 : 0;
        }
        
        if(memo[index][totalSum + currSum] != Integer.MIN_VALUE) {
            return memo[index][totalSum + currSum];
        }
        
        int add = solve(index + 1, currSum + nums[index], nums, target);
        int subtract = solve(index + 1, currSum - nums[index], nums, target);
        
        return memo[index][totalSum + currSum] = add + subtract;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        
        memo = new int[n][2 * totalSum + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        
        return solve(0, 0, nums, target);
    }
}