class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        
        int maxOR = getMaxOr(nums);
        
        int count = 0;
        
        for(int k = 0; k < Math.pow(2, n); k++) {
            int currOR = 0;
            
            for(int i = 0; i < n; i++) {
                if(((1 << i) & k) != 0) {
                    currOR = currOR | nums[i];
                }
            }
            
            if(currOR == maxOR) {
                count++;
            }
        }

        return count;
    }
    
    private int getMaxOr(int[] nums) {
        int maxOR = 0;
        
        for(int num : nums) {
            maxOR = maxOR | num;
        }
        
        return maxOR;
    }
}