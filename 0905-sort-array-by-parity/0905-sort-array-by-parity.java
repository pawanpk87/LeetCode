class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for(int i = 0, j = n-1; i<j; ){
            if(nums[i]%2 == 0)
                i++;
            else if(nums[j]%2 != 0)
                j--;
            else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }
}
