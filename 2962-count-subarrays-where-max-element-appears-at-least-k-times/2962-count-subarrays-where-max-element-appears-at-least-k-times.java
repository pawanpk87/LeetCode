class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int maxNum = getMaxNum(nums);
        int i = 0, j = 0, currCount = 0;
        while(j < n){
            if(nums[j] == maxNum){
                currCount++;
            }
            while(currCount >= k){
                ans += (n - j);  // valid subarray from j to n-1
                if(nums[i] == maxNum){
                    currCount--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
    
    private int getMaxNum(int nums[]){
        int n = nums.length;
        int maxNum = 0;
        for(int i = 0; i < n; i++){
            maxNum = Math.max(maxNum, nums[i]);
        }
        return maxNum;
    }
}