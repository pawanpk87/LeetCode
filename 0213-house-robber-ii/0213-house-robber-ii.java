class Solution {
    private int[] memo;
    
    private int solve(int currHouse, int[] nums, int n){
        if(currHouse >= n) {
            return 0;
        }    
        
        if(memo[currHouse] != -1) {
            return memo[currHouse];
        }
        
        int pos1 = nums[currHouse] + solve(currHouse + 2, nums, n);
        int pos2 = solve(currHouse + 1, nums, n);
        
        return memo[currHouse] = Math.max(pos1, pos2);
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1) {
            return nums[0];
        }
        
        memo = new int[n];
        
        Arrays.fill(memo, -1);
        int pos1 = solve(0, nums, n - 1);
        
        Arrays.fill(memo, -1);
        int pos2 = solve(1, nums, n);
        
        return Math.max(pos1, pos2);
    }
}