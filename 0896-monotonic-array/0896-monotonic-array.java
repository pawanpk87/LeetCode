class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int type = -1;
        for(int i = 1; i < n; i++){
            if(nums[i-1] < nums[i]){
                if(type == -1) type = 1;
                else if(type == 0) return false;
            }else if(nums[i-1] > nums[i]){
                if(type == -1) type = 0;
                else if(type == 1) return false;
            }
        }
        return true;
    }
}