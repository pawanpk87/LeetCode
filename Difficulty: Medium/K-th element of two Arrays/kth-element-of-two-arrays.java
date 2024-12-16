//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
       int n = a.length, m = b.length;
       int i = 0, j = 0;
       
       int currNum = -1;
       while(i < n && j < m) {
           if(a[i] < b[j]) {
               currNum = a[i];
               i++;
           } else {
               currNum = b[j];
               j++;
           }
           
           k--;
           
           if(k == 0) {
               return currNum;
           }
       }
       
       while(i < n) {
           if(k == 1) {
               return a[i];
           }
           k--;
           i++;
       }
       
       while(j < m) {
           if(k == 1) {
               return b[j];
           }
           k--;
           j++;
       }
       
       return -1;
    }
}