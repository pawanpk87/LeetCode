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


// User function Template for Java

class Solution {
    private int[] getLPS(String pattern) {
        int n = pattern.length();

        int[] lps = new int[n];

        lps[0] = 0;

        int len = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(len) == pattern.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    private ArrayList<Integer> kmp(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        ArrayList<Integer> res = new ArrayList<>();

        int[] lps = getLPS(pattern);

        int i = 0;
        int j = 0;

        while ((n - i) >= (m - j)) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                res.add(i - j);
                j = lps[j - 1];
            } else if (i < n && str.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return res;
    }
    
    ArrayList<Integer> search(String pat, String txt) {
        return kmp(txt, pat);
    }
}