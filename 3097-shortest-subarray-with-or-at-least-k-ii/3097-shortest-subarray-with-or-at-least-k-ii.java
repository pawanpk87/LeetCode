class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        
        int[] setBitCount = new int[32];
        
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0;
        
        while(j < n) {
            addXorNum(setBitCount, nums[j]);
            
            while(getNum(setBitCount) >= k && i <= j) {
                minLen = Math.min(minLen, (j - i + 1));
                removeXorNum(setBitCount, nums[i]);
                i++;
            }
            
            j++;
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    
    private int getNum(int[] setBitCount) {
        int num = 0;
        
        for(int i = 0; i < 32; i++) {
            if(setBitCount[i] >= 1) {
                num = num | (1 << i);
            }
        }
        
        return num;
    }
    
    private void addXorNum(int[] setBitCount, int num) {
        for(int i = 0; i < 32; i++) {
            if(((1 << i) & num) != 0) {
                setBitCount[i]++;
            }
        }   
    }
    
    private void removeXorNum(int[] setBitCount, int num) {
        for(int i = 0; i < 32; i++) {
            if(((1 << i) & num) != 0 && setBitCount[i] > 0) {
                setBitCount[i]--;
            }
        }
    }
}

/*

    nums = [1,2,3], k = 2
    
    
    1 ->  000001
    2 ->  000010
    3 ->  000011
    
        
          000001 
          000010 <-
          000011
          
          
          000011
          
          000011 -> 3
*/