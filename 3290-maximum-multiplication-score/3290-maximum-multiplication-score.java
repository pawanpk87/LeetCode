class Solution {
    long[][] memo;
    private long maxScoreUtil(int ia, int ib, int[] a, int[] b) {
        if(ia == a.length) {
            return 0;
        }
        
        if(ib >= b.length) {
            return (long) -1e9;
        }
        
        if(memo[ia][ib] != -1) {
            return memo[ia][ib];
        }
        
        long opt1 = (long) a[ia] * b[ib] + maxScoreUtil(ia+1, ib+1, a, b);
        long opt2 = maxScoreUtil(ia, ib+1, a, b);
        
        return memo[ia][ib] = Math.max(opt1, opt2);
    }
    
    public long maxScore(int[] a, int[] b) {
        memo = new long[4][b.length];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return maxScoreUtil(0, 0, a, b);
    }
}