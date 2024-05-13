class Solution {
    private int solve(int start, int[] arr, int k, int[] memo){
        if(start >= arr.length){
            return 0;
        }    
        
        if(memo[start] != -1){
            return memo[start];
        }
        
        int maxSum = 0;
        int currMax = Integer.MIN_VALUE;
        int end = Math.min(start + k, arr.length);
        for(int i = start; i < end; i++){
            currMax = Math.max(currMax, arr[i]);
            maxSum = Math.max(maxSum, (currMax * (i - start + 1) + solve(i+1, arr, k, memo)));
        }
        
        return memo[start] = maxSum;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        return solve(0, arr, k, memo);
    }
}