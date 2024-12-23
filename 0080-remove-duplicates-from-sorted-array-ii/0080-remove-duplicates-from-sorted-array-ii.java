class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        int currNum = nums[0];
        int currCount = 1;
        
        int i = 1, j = 1;
        
        while(i < n) {
            if(nums[i] == currNum) {
                if(currCount == 1) {
                    nums[j] = nums[i];
                    
                    i++;
                    j++;
                    
                    currCount++;
                } else {
                    i++;
                }
            } else {
                nums[j] = nums[i];
                
                currNum = nums[j];
                currCount = 1;
                
                i++;
                j++;
            }
        }
        
        return j;
    }
}
/*
    
    1.)  remove some duplicates in-place such that each 
         unique element appears at most twice. 
         
    2.) The relative order of the elements should be kept the same.
    
    
    nums = [1,1,2,2,2,3]
                      |
            
    nums = [1,1,2,2,3,_]
                    |
    
    currNum = nums[0]
    count = 1
    
    i = 1
    j = 1
    
    
    
    
    
    
        
    

*/