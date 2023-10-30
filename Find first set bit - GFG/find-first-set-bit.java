//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends
class Solution{
    public static int getFirstSetBit(int n){
        int firstBitIndx = 1;
        while(n > 0){
            if((n&1)!=0){
                return firstBitIndx;
            }
            firstBitIndx++;
            n = n>>1;
        }
        return 0;
    }
}