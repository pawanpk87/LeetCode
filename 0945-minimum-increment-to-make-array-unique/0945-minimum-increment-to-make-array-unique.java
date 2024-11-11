class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int minIncrements = 0;
        
        for(int i = 1; i < n; i++) {
            if(nums[i] <= nums[i - 1]) {
                int inc = nums[i - 1] - nums[i];
                
                minIncrements += inc;
                
                nums[i] = nums[i - 1] + 1;
                
                minIncrements++;
            }
        }
        
        return minIncrements;
    }
}