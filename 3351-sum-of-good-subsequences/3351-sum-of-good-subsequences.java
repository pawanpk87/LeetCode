class Solution {
    public static int MOD = 1_000_000_007;
    
    public int sumOfGoodSubsequences(int[] nums) {
        int n = nums.length;
        
        int maxNum = 0;
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        long[] subsequenceCountEndingWithNum = new long[maxNum + 1];
        long[] sumOfSubsequenceEndingWithNum = new long[maxNum + 1];
        
        for(int num : nums) {
            // every element itself can be a subsequence
            subsequenceCountEndingWithNum[num] = subsequenceCountEndingWithNum[num] + 1;
            
            // every element itself can be good subsequence
            sumOfSubsequenceEndingWithNum[num] = (sumOfSubsequenceEndingWithNum[num] + num) % MOD;
            
            
            // Possible subsequences
            
            // num - 1
            if(num - 1 >= 0) {
                // total sum ending at subsequence num
                sumOfSubsequenceEndingWithNum[num] = (
                    sumOfSubsequenceEndingWithNum[num] +
                    sumOfSubsequenceEndingWithNum[num - 1] +
                    (num * subsequenceCountEndingWithNum[num - 1]) % MOD
                ) % MOD;
                
                // total number of subsequence ending at num
                subsequenceCountEndingWithNum[num] = (
                    subsequenceCountEndingWithNum[num] +
                    subsequenceCountEndingWithNum[num - 1]
                ) % MOD;
            }
            
            // num - 1
            if(num + 1 <= maxNum) {
                // total sum ending at subsequence num
                sumOfSubsequenceEndingWithNum[num] = (
                    sumOfSubsequenceEndingWithNum[num] +
                    sumOfSubsequenceEndingWithNum[num + 1] +
                    (num * subsequenceCountEndingWithNum[num + 1]) % MOD
                ) % MOD;
                
                // total number of subsequence ending at num
                subsequenceCountEndingWithNum[num] = (
                    subsequenceCountEndingWithNum[num] +
                    subsequenceCountEndingWithNum[num + 1]
                ) % MOD;
            }
        }

        long totalSum = 0;
        
        for(int i = 0; i <= maxNum; i++) {
            totalSum = (totalSum + sumOfSubsequenceEndingWithNum[i]) % MOD;
        }
        
        return (int) totalSum;
    }
}