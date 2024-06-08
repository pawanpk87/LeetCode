class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        while(j < n){
            target -= nums[j];
            while(target <= 0){
                minLen = Math.min(minLen, (j - i) + 1);
                target += nums[i++];
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}