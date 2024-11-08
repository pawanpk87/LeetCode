class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        
        int[] queryRes = new int[n];
        
        int currXor = 0;
        
        for(int i = 0; i < n; i++) {
            currXor = currXor ^ nums[i];
            
            int setBitPos = getSetBitPos(((int) Math.pow(2, maximumBit)) - 1);
            
            int k = 0;
            for(int bitPos = 0; bitPos <= setBitPos; bitPos++) {
                if(((1 << bitPos) & currXor) == 0) {
                    k = k | (1 << bitPos);
                }
            }
            
            queryRes[n - i - 1] = k;
        }
        
        return queryRes;
    }
    
    private int getSetBitPos(int num) {
        int pos = (int) (Math.log(num) / Math.log(2));
        return pos;
    }
}
/*
    
    nums = [0,1,1,3], maximumBit = 2
    
    2^maximumBit = 4
    
    
    00000
    00001
    00001
    00011
    -----
    00011 -> 3
    
    
    
    k = ?  
    k < 4
    
    3 ^ k 
    
    
    00011 -> 3
    00000
    -----
    00111 >= 3
    
    
    take number 1 ----- 3
    
    1       0000001
    2       0000010
    3       0000011
    .
    .
    .
    k-1     00110101
              |
              
              set bit 
    most significat bit  
    
    000001
    
    000011    
*/