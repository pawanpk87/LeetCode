class Solution {
    private int countPairsWithDifference(int[] nums, int x) {
        int n = nums.length;
        
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if((nums[j] - nums[i]) <= x) {
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count;
    }
    
    
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int low = 0, high = nums[nums.length - 1];
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            int countPairs = countPairsWithDifference(nums, mid);
            
            if(countPairs < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}