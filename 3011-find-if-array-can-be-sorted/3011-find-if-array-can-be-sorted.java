class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        
        int minOfSegment = nums[0];
        int maxOfSegment = nums[0];
    
        int maxOfPrevSegment = Integer.MIN_VALUE;
        
        int bitCount = Integer.bitCount(nums[0]);
        
        for(int i = 1; i < n; i++) {
            if(bitCount == Integer.bitCount(nums[i])) {
                minOfSegment = Math.min(minOfSegment, nums[i]);
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
            } else {
                if(minOfSegment < maxOfPrevSegment) {
                    return false;
                }
                
                maxOfPrevSegment = maxOfSegment;
                
                minOfSegment = nums[i];
                maxOfSegment = nums[i];
                
                bitCount = Integer.bitCount(nums[i]);
            }
        }
        
        if(minOfSegment < maxOfPrevSegment) {
            return false;
        }
        
        return true;
    }
}