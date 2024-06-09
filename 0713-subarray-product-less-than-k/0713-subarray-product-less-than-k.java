class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int i = 0, j = 0;
        long currProd = 1;
        while(j < n){
            currProd *= nums[j];
            while(i <= j && currProd >= k){
                currProd /= nums[i++];
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}