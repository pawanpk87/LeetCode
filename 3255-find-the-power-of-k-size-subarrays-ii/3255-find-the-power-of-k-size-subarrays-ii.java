class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        
        if(n == 1 || k == 1) {
            return nums;
        }
        
        int[] res = new int[(n-k+1)];
        
        int index = 0;
        int i = 0, j = 1;
        
        while(j < n) {
            if(k != 1 && nums[j] != nums[j-1] + 1) {
                while(i <= (n-k) && i < j) {
                    res[index] = -1;
                    index++;
                    i++;
                }
            }
            
            if((j - i + 1) == k) {
                res[index] = nums[j];
                index++;
                i++;
            }
            
            j++;
        }
        
        return res;
    }
}