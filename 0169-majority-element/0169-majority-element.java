class Solution {
    public int majorityElement(int[] nums) {
        int majorityNum = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != majorityNum) {
                count--;
                if(count == 0) {
                    majorityNum = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return majorityNum;
    }
}