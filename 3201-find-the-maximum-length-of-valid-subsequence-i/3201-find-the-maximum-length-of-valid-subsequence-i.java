class Solution {
    private int sameParity(int[] nums){
        int n = nums.length;
        
        int[] even = new int[n];
        even[0] = nums[0]%2 == 0 ? 1 : 0;
        for(int i = 1; i < n; i++){
            if(nums[i]%2 == 0){
                even[i] = even[i-1] + 1;
            } else{
                even[i] = even[i-1];
            }
        }
        
        int[] odd = new int[n];
        odd[0] = nums[0]%2 != 0 ? 1 : 0;
        for(int i = 1; i < n; i++){
            if(nums[i]%2 != 0){
                odd[i] = odd[i-1] + 1;
            } else{
                odd[i] = odd[i-1];
            }
        }
        
        return Math.max(even[n-1], odd[n-1]);
    }
    
    private int diffPartity(int[] nums){
        int n = nums.length;
        
        int[] even = new int[n];    // odd -> even
        int[] odd = new int[n];     // even -> odd
        
        even[0] = nums[0]%2 == 0 ? 1 : 0;
        odd[0] = nums[0]%2 != 0 ? 1 : 0;
        
        for(int i = 1; i < n; i++){
            if(nums[i]%2 == 0){
                even[i] = odd[i-1] + 1;
                odd[i] = odd[i-1];
            } else{
                odd[i] = even[i-1] + 1;
                even[i] = even[i-1];
            }
        }
        
        return Math.max(even[n-1], odd[n-1]);
    }
    
    public int maximumLength(int[] nums) {
        return Math.max(sameParity(nums), diffPartity(nums));
    }
}