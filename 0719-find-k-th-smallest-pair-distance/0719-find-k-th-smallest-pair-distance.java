class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        
        int maxElement = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }
        
        int[] bucket = new int[maxElement + 1];
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                bucket[diff]++;
            }
        }
        
        for(int i = 0; i <= maxElement; i++) {
            k -= bucket[i];
            if(k <= 0) {
                return i;
            }
        }
        
        return -1;
    }
}