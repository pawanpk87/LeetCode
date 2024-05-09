class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1, k = 0;
        while(k <= j){
            if(nums[i] == 0){
                i++;
                k++;
            }
            else if(nums[j] == 2) j--;
            else{
                if(nums[k] == 2){
                    swap(nums, k, j);
                } else if(nums[k] == 0){
                    swap(nums, k, i);
                } else{
                    k++;
                }
            }
            //System.out.println(i + " " + j + " " + k);
        }
    }
}