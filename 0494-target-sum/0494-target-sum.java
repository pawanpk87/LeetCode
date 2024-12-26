class Solution {
    private int solve(int index, int[] nums, int target) {
        if(index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        
        int opt1 = solve(index + 1, nums, target + nums[index]);
        int opt2 = solve(index + 1, nums, target - nums[index]);
        
        return opt1 + opt2;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, nums, target);
    }
}
/*
    
    nums = [1,1,1,1,1], target = 3
    
    -1 + 1 + 1 + 1 + 1 = 3
    
    
    1.) adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
    
    
    
    
        [1,1,1,1,1]
         |
        / \
      +     -
            
     target = 4     target = 2
     1,1,1,1]       1,1,1,1]
     |              |
    / \            / \
   +   -          +   -
 

*/