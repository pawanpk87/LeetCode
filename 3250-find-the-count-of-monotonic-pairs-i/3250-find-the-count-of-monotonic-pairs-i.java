class Solution {
    int[][] memo;
    int mod = 1000000007;
    
    private int countOfPairsUtil(int index, int prevNoDec, int prevNoInc, int[] nums) {
        if(index == nums.length) {
            return 1;
        }
        
        if(memo[index][prevNoDec] != -1) {
            return memo[index][prevNoDec];
        }
        
        int count = 0;
        
        for(int num = prevNoDec; num <= nums[index]; num++) {
            for(int num2 = nums[index]; num2 >= 0; num2--) {
                if(num2 <= prevNoInc && (num + num2) == nums[index]) {
                    count = (count + countOfPairsUtil(index + 1, num, num2, nums)) % mod;
                }
            }
        }
        
        return memo[index][prevNoDec] = count;
    }
    
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        
        memo = new int[n][51];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return countOfPairsUtil(0, 0, Integer.MAX_VALUE, nums);
    }
}