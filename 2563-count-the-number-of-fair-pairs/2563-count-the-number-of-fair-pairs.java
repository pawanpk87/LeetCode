class Solution {
    private long binarySearch(int low, int high, int targetNum, int[] nums) {
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] >= targetNum) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        long count = 0;
        
        for(int i = 0; i < n; i++) {
            long low = binarySearch(i + 1, n - 1, lower - nums[i], nums);
            long high = binarySearch(i + 1, n - 1, upper - nums[i] + 1, nums);
            count += (high - low);
        }
        
        return count;
    }
}