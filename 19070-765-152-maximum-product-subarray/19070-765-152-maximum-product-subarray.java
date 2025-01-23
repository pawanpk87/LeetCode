class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int maxProd = nums[0];
        
        int posProd = nums[0];
        int negProd = nums[0];
        
        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                int temp = posProd;
                posProd = negProd;
                negProd = temp;
            }
            
            posProd = Math.max(nums[i], posProd * nums[i]);
            negProd = Math.min(nums[i], negProd * nums[i]);
            
            maxProd = Math.max(maxProd, Math.max(posProd, negProd));
        }
        
        return maxProd;
    }
}