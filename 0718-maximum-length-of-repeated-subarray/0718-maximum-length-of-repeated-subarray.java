class Solution {
    private int ans = 0;
    
    private int[][] memo;
    
    private int solve(int i, int j, int[] nums1, int[] nums2){
        if(i >= nums1.length || j >= nums2.length){
            return 0;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        int maxLen = 0;
        
        if(nums1[i] == nums2[j]){
            maxLen = 1 + solve(i+1, j+1, nums1, nums2);
            ans = Math.max(ans, maxLen);
        }
        
        solve(i+1, j, nums1, nums2);
        solve(i, j+1, nums1, nums2);
        
        return memo[i][j] = maxLen;
    }
    
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        
        memo = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        
        solve(0, 0, nums1, nums2);
        
        return ans;
    }
}