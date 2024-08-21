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
    int MOD = 1000000007;
    int[][] memo;
    
    int countWaysUtil(int index, int targetSum, int[] nums) {
        if(targetSum == 0) {
            return 1;
        }
        
        if(index == nums.length) {
            return 0;
        }
        
        if(memo[index][targetSum] != -1) {
           return memo[index][targetSum]; 
        }
        
        int pos1 = 0;
        int pos2 = 0;
        
        if(nums[index] <= targetSum) {
            pos1 = countWaysUtil(index, targetSum - nums[index], nums);
        } 
        
        pos2 = countWaysUtil(index + 1, targetSum, nums);
        
        return memo[index][targetSum] = (pos1 + pos2) % MOD;
    }
    
    int countWays(int n) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        
        memo = new int[n][n+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return countWaysUtil(0, n, nums) - 1;\
    }
}
