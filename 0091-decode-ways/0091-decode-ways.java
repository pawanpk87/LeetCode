class Solution {
    int memo[];
    
    private int solve(String s, int n){
        if(n == 0 || n == 1){
            return 1;
        }
        
        if(memo[n] != -1){
            return memo[n];
        }
        
        int opt1 = 0, opt2 = 0;
        
        if(s.charAt(n-1) > '0'){
            opt1 = solve(s, n-1);
        }
        
        if(s.charAt(n-2) == '1' || (s.charAt(n-2) == '2' && s.charAt(n-1) < '7')){
            opt2 = solve(s, n-2);
        }
        
        return memo[n] = (opt1 + opt2);
    }
    
    public int numDecodings(String s) {
        int n = s.length();
        
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        if(n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        
        return solve(s, n);
    }
}