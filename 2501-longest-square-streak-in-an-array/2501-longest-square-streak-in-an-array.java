class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        Map<Integer, Integer> sqrValues = new HashMap<>();
        
        int maxSqrStreak = 1;
        
        for(int i = n-1; i >= 0; i--) {
            int nextSqr = (int) Math.pow(nums[i], 2);
            
            if(sqrValues.containsKey(nextSqr)) {
                sqrValues.put(nums[i], sqrValues.get(nextSqr) + 1);
            } else {
                sqrValues.put(nums[i], 1);
            }
            
            maxSqrStreak = Math.max(maxSqrStreak, sqrValues.get(nums[i]));
        }
        
        return maxSqrStreak == 1 ? -1 : maxSqrStreak;
    }
}

/*
    
      [4,  3,  6,  16, 8,  2]
      
      [4, 16, 2]
      [2, 4, 16]
      
    
      [4, 16] 

    
        
      [4,  3,  6,  16, 8,  2]
      
      [2,  3,  4,  6,  8,  16, 16, 16, 16, 56, 64]
       1   1   3   1   1    2   2   2   2   1   1

      1.) sort the nums
      2.) initialize the dp[n] with value 1
      4.) take set to trac the next sqr value for curr num
      3.) iterate from last
            check if the sqr value exist if 
            yes then
                    dp[i] = mp.get(Math.pow(nums[i], 2)) + 1;
            no then
                    do nothing
          
          keep track of the maximum lenth square streak
*/