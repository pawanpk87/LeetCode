class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum_so_far = Integer.MIN_VALUE;
        int sum_so_far = 0;
        
        for(int num : nums) {
            sum_so_far += num;
            
            if(max_sum_so_far < sum_so_far) {
                max_sum_so_far = sum_so_far;
            }
            
            if(sum_so_far < 0) {
                sum_so_far = 0;
            }
        }
        
        return max_sum_so_far;
    }
}