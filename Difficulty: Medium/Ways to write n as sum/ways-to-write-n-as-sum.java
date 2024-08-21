//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());

            int res = new Solution().countWays(n);

            System.out.println(res);
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int MOD = 1000000007;
    
    int countWays(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for(int i = 1; i < n; i++) {
            for(int j = i; j <= n; j++) {
                dp[j] = (dp[j] + dp[j-i]) % MOD; 
            }
        }
        
        return dp[n];
    }
}
