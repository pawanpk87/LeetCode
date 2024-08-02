class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int ws = 0;
        for(int num : nums) {
            if(num == 1){
                ws++;
            }
        }
        
        int ones = getCount(nums, 1, ws);
        int zeros = getCount(nums, 0, ws);
        
        int minSwaps = zeros;
        
        int i = 0, j = ws;
        while(j < (n+ws-1)) {
            if(nums[(j%n)] == 1) {
                ones++;
            } else {
                zeros++;
            }
            
            if(nums[i] == 1){
                ones--;
            } else {
                zeros--;
            }
            
            minSwaps = Math.min(minSwaps, zeros);
            
            i++;
            j++;
        }
        
        return minSwaps;
    }
    
    public int getCount(int[] nums, int num, int ws) {
        int count = 0;
        for(int i = 0; i < ws; i++){
            if(nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}