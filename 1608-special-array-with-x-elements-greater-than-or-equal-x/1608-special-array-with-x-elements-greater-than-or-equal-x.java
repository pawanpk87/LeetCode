class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = n;
        for(int i = 0; i < n; i++){
            if(nums[i] >= count){
                return count;
            } else{
                count--;
                if(count <= nums[i]){
                    return -1;
                }
            }
        }
        return -1;
    }
}