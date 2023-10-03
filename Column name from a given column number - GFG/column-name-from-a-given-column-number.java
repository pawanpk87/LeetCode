//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends

class Solution{
    String colName (long columnNumber){
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            if(columnNumber > 26){
                long rem = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
                columnNumber -= rem;
                columnNumber /= 26;
                rem--;
                sb.append((char)(rem + 'A'));
            }else{
                columnNumber--;
                sb.append((char)(columnNumber + 'A'));
                break;
            }
        }
        return sb.reverse().toString();
    }
}