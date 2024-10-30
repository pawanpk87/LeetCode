class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] LICleft = new int[n];
        int[] LICright = new int[n];
        
        Arrays.fill(LICleft, 1);
        Arrays.fill(LICright, 1);
        
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && LICleft[j] + 1 > LICleft[i]) {
                    LICleft[i] = LICleft[j] + 1;
                }
            }
        }
        
        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(nums[j] < nums[i] && LICright[j] + 1 > LICright[i]) {
                    LICright[i] = LICright[j] + 1;
                }
            }
        }
        
        int maxLen = 0;
        
        for(int i = 1; i < n-1; i++) {
            if(LICleft[i] > 1 && LICright[i] > 1) {
                maxLen = Math.max(maxLen, LICleft[i] + LICright[i] - 1);
            }
        }
        
        return n - maxLen;
    }
}