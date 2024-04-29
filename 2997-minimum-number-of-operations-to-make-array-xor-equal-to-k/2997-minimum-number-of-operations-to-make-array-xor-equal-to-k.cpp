class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int n = nums.size();
        
        int xorOfNums = 0;
        for(auto& num : nums){
            xorOfNums = xorOfNums ^ num;
        }
        
        int count = 0;
        while(xorOfNums > 0 || k > 0){
            if((k&1) != (xorOfNums&1)){
                count++;
            } 
            xorOfNums = xorOfNums >> 1;
            k = k >> 1;
        }
        
        return count;
    }
};
/*
    nums = [2,1,3,4], k = 1
    
    
    0 0 0 0 -> 0
    0 0 0 1 -> 1
    0 0 1 0 -> 2
    0 0 1 1 -> 3
    0 1 0 0 -> 4
    0 1 0 1 -> 5
    0 1 1 0 -> 6
    0 1 1 1 -> 7
    1 0 0 0 -> 8
    
    1 0 0 1 -> 9
    
    1 1 0 0 -> 12
    
    1 1 1 0 -> 14

    [9,7,9,14,8,6]  12
    
    
    1 0 0 1 -> 9
    0 1 1 1 -> 7
    1 0 0 1 -> 9
    1 1 1 0 -> 14
    1 0 0 0 -> 8
    0 1 1 0 -> 6
    
    0 1 1 1
    
    1 1 0 0 -> 12
    
    1 0 1 1
    
    
    
    
    
  
    
    
    
    
    
    
     
     
     

    
    
    
*/