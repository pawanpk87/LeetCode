//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    private int[] constructLPS(String str) {
        int n = str.length();
        
        int[] lps = new int[n];
        
        lps[0] = 0;
        
        int i = 1;
        int len = 0;
        
        while(i < n) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        
        return lps;
    }
    
    private ArrayList<Integer> KMPAlgorithm(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int[] lps = constructLPS(pattern);
        
        int i = 0, j = 0;
        
        while(i < n) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            
            if(j == m) {
                res.add(i - j);
                j = lps[j - 1];
            } else if(i < n && text.charAt(i) != pattern.charAt(j)){
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        
        return res;
    }
    
    ArrayList<Integer> search(String pat, String txt) {
        return KMPAlgorithm(txt, pat);
    }
}