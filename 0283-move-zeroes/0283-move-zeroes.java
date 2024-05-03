class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        while(j < n){
            if(nums[j] != 0){
                swap(nums, j, i);
                i++;
            }
            j++;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int tempNum = nums[i];
        nums[i] = nums[j];
        nums[j] = tempNum;
    }
}