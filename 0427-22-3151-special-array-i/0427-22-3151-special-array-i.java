class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;

        for(int i = 1; i < n; i++) {
            if((isEven(nums[i - 1]) && isEven(nums[i])) ||
               (isOdd(nums[i - 1]) && isOdd(nums[i]))) {
                return false;
            }
        }

        return true;
    }

    private boolean isEven(int num) {
        return num%2 == 0;
    }

    private boolean isOdd(int num) {
        return num%2 != 0;
    }
}