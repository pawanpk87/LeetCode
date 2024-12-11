class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        
        int maxLen = 0;
        int start = 0;
        
        for(int i = 0; i < nums.length; i++) {
            while((nums[i] - nums[start]) > (2*k)) {
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}