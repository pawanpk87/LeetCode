class Solution {
    int[] memo;
    
    private int numSquaresUtil(int n) {
        if(n <= 3) {
            return n;
        }    
        
        if(memo[n] != -1) {
            return memo[n];
        }
        
        int minNumPerfectSqrs = Integer.MAX_VALUE;
        
        for(int i = 1; i*i <= n; i++){
            minNumPerfectSqrs = Math.min(minNumPerfectSqrs, 1 + numSquaresUtil(n - (i * i)));
        }
        
        return memo[n] = minNumPerfectSqrs;
    }
    
    public int numSquares(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return numSquaresUtil(n);
    }
}