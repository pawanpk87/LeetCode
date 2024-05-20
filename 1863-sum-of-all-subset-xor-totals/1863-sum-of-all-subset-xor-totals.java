class Solution {
    private int totalSum = 0;
    
    private void solve(int currIndex, int currNum, int[] nums, int n){
        if(currIndex >= n){
            totalSum += currNum;
        } else{
            solve(currIndex + 1, currNum ^ nums[currIndex], nums, n);
            solve(currIndex + 1, currNum, nums, n);
        }
    }
    
    public int subsetXORSum(int[] nums) {
        solve(0, 0, nums, nums.length);
        return totalSum;
    }
}