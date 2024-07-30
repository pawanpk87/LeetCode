//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int n, int sum) {
        /*
        
            sum == 0
                return 1
            
            pos1 = pick the current coin if possible
            pos2 = don't pick the coin
            
            pos1 + pos2
        
        */
        
        long[][] dp = new long[n+1][sum+1];
        
        /*
            let's say we have 
            coins = 0
            sum = 0
            then how many sum we can make 
            ans = 0
            
            dp[0][0] = 1
    
        */
        
        dp[0][0] = 1;
        
        /*
            let's say we have
            coins = [some coin...]
            sum = 0
            then how many sum we can make 
            ans = 1 
            
            let's say we hav e
            coins = 0
            sum = sum number
            then how many sum we can make 
            ans = 0
        */
        
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for(int j = 1;  j <= sum; j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j - coins[i-1]];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        
        return dp[n][sum];
    }
}