class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int maxAndValue = 0;
        int currLen = 0;
        
        for(int num : nums) {
            if(maxAndValue < num) {
                maxAndValue = num;
                maxLen = currLen = 0;
            }
            
            if(maxAndValue == num) {
                currLen++;
            } else {
                currLen = 0;
            }
            
            maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen;
    }
}