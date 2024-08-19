class Solution {
    private int solve(int currNumChars, int copiedChars, int n) {
        if(currNumChars == n) {
            return 0;
        }    
        
        int opt1 = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;
        
        if((currNumChars + currNumChars) <= n) {
            int res = solve(currNumChars + currNumChars, currNumChars, n);
            if(res != Integer.MAX_VALUE) {
                opt1 = 2 + res;
            }
        }   
        
        if(copiedChars > 0 && (currNumChars + copiedChars) <= n) {
            int res = solve(currNumChars + copiedChars, copiedChars, n);
            if(res != Integer.MAX_VALUE) {
                opt2 = 1 + res;
            }
        }
        
        return Math.min(opt1, opt2);
    }
    
    public int minSteps(int n) {
        return solve(1, 0, n);
    }
}