//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String trimLeadingZeros(String s) {
        int firstOne = s.indexOf('1');
        return (firstOne == -1) ? "0" : s.substring(firstOne);
    }
    
    static String addBinary(String s1, String s2) {
        s1 = trimLeadingZeros(s1);
        s2 = trimLeadingZeros(s2);
        
        int n = s1.length();
        int m = s2.length();
    
        if (n < m) {
            return addBinary(s2, s1);
        }
    
        int j = m - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
    
        for (int i = n - 1; i >= 0; i--) {
            int bit1 = s1.charAt(i) - '0';
            int sum = bit1 + carry;
    
            if (j >= 0) {
                int bit2 = s2.charAt(j) - '0';
                sum += bit2;
                j--;
            }
    
            int bit = sum % 2;
            carry = sum / 2;
            result.append((char)(bit + '0'));
        }
    
        if (carry > 0)
            result.append('1');
    
        return result.reverse().toString();
    }

}