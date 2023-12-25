class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        if(n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        
        int dp[] = new int[n+1];
        
        dp[0] = 1; // number of ways to decode empty string
        dp[1] = 1; // number of ways to decode string of length 1
        
        for(int i = 2; i <= n; i++){
            if(s.charAt(i-1) > '0'){
                dp[i] += dp[i-1];
            }   
            
            if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7')){
                dp[i] += dp[i-2];    
            }
            
            /*
                dp[i] = number of ways to decode string of length i
                
                if(s.charAt(i-1) > '0'){
                    // if current character is valid then call for the i-1 length string
                    dp[i] += dp[i-1];
                }
                
                if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) > '7')){
                    // if the current 2 characters is valid then call for the i-2 lenght string
                    dp[i] += dp[i-2];    
                }
            */
        }
        
        return dp[n];
    }
}