//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution { 
    // static int[][] memo;
    
    // static int solve(int index, int W, int[] wt, int[] val) {
    //     if(index == wt.length) {
    //         return 0;
    //     }
        
    //     if(memo[index][W] != -1){
    //       return memo[index][W]; 
    //     }
    //     int pos1 = 0, pos2 = 0;
        
    //     if(wt[index] <= W) {
    //         pos1 = val[index] + solve(index + 1, W-wt[index], wt, val);
    //     } 
        
    //     pos2 = solve(index + 1, W, wt, val);   
        
    //     return memo[index][W] = Math.max(pos1, pos2);
    // }
    
    static int knapSack(int W, int wt[], int val[], int n) { 
        int[][] dp = new int[n+1][W+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = val[i-1] + dp[i-1][j - wt[i-1]];
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }
        return dp[n][W];
    } 
}


