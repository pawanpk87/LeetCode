class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxPairSum = 0;
        for(int i = 0; i < (n/2); i++){
            maxPairSum = Math.max(maxPairSum, nums[i] + nums[n-i-1]);
        }
        return maxPairSum;
    }
}