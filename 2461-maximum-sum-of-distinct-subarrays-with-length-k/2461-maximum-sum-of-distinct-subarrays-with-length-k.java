class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        long maxSum = 0;
        long currSum = 0;
        
        int i = 0, j = 0;
        
        while(j < n) {
            currSum += nums[j];
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            
            while((j - i + 1) > k || freq.get(nums[j]) > 1) {
                currSum -= nums[i];
                freq.put(nums[i], freq.get(nums[i]) - 1);
                
                if(freq.get(nums[i]) == 0) {
                    freq.remove(nums[i]);
                }
                
                i++;
            }
            
            if((j - i + 1) == k) {
                maxSum = Math.max(maxSum, currSum);
            }
            
            j++;
        }
        
        return maxSum;
    }
}