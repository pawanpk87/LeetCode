//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N = sc.nextInt();
            int K = sc.nextInt();
           
            Solution ob = new Solution();
            int ans = ob.setKthBit(N,K);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setKthBit(int N,int K){
        return (N|(1<<K));
    }
}