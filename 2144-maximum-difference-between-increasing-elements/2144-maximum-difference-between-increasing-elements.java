class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;

        int maxDiff = -1;
        int minNum = nums[0];

        for(int j = 1; j < n; j++) {
            if(minNum < nums[j]) {
                maxDiff = Math.max(maxDiff, nums[j] - minNum);
            }
            minNum = Math.min(minNum, nums[j]);
        }

        return maxDiff;
    }
}