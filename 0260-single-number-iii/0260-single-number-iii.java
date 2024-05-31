class Solution {
    public int[] singleNumber(int[] nums) {
        int xorNum = 0;
        
        for(int num : nums){
            xorNum = xorNum ^ num;
        }
        
        int rightMostFirstBit = 1;
        while((xorNum & rightMostFirstBit) == 0){
            rightMostFirstBit <<= 1;
        }
        
        int first = 0;
        for(int num : nums){
            if((num & rightMostFirstBit) != 0){
                first = first ^ num;
            }
        }
        
        int second = xorNum ^ first;
        
        return new int[]{first, second};
    }
}