class Solution {
    private int maxSizeSubarray(int[] nums, int sum){
        int n = nums.length;
        int maxLen = -1;
        int i = 0, j = 0;
        int currSum = 0;
        while(j < n){
            currSum += nums[j];
            while(i <=j && currSum > sum){
                currSum -= nums[i++];
            }
            if(currSum == sum){
                maxLen = Math.max(maxLen, (j - i + 1));
            }
            j++;
        }
        return maxLen;
    }
    
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int maxLen = maxSizeSubarray(nums, totalSum - x);
        if(maxLen == -1){
            return -1;
        }
        return n - maxLen;
    }
}