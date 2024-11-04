//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static long MOD = 1000000007;

    public static long multiMod(long a, long b) {
        long na = a % MOD;
        long nb = b % MOD;
        return (na * nb) % MOD;
    }

    // O(log k)
    public static long powModularExponentiation(long n, long k) {
        if (k == 0) {
            return 1;
        }
        if (k % 2 == 0) {
            return powModularExponentiation(multiMod(n, n), k/2);
        } else {
            return multiMod(n, powModularExponentiation(n, k - 1));
        }
    }
    
    public long PowMod(long x, long n, long m){
        MOD = m;
        return powModularExponentiation(x, n);
    }
}