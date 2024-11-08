//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    static int[] getLPS(String str) {
        int n = str.length();
        
        int[] lps = new int[n];
        
        int len = 0;
        int index = 1;
        
        while(index < n) {
            if(str.charAt(index) == str.charAt(len)) {
                len++;
                lps[index] = len;
                index++;
            } else {
                if(len == 0) {
                    lps[index] = 0;
                    index++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        
        return lps;
    }
    
    static boolean checkStringExistKTimes(String targetStr, String s, int k) {
        int n = targetStr.length();
        int m = s.length();
        
        int[] lps = getLPS(s);
        
        int i = 0, j = 0;
        
        while(i < n*k) {
            if(targetStr.charAt(i % n) == s.charAt(j)) {
                i++;
                j++;
                
                if(j == m) {
                    return true;
                }
            } else {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return false;    
    }
    
    static int minRepeats(String s1, String s2) {
        /*
    
    Knuth–Morris–Pratt algorithm:
                If the begining part of the string is appearing again somewhere in the string
                then don't compare the characters avoid the comparasion
                
            ex:
                a b c u m e a b c o l y
                -----       -----
            
                
                prefix: a, ab, abc ...
                suffix: y, ly,... c, bc, abc..
                
                
                in KMP we generate LPA(longest prefix string which is also proper suffix)
                    
                     a b c d a b e a b c f
                LPS  0 0 0 0 0 0 0 0 0 0 0
                     0 0 0 0 1 2 0 1 2 3 0
                
                
                    
                    Generate LPS
                        
                        len = 0
                        index = 1;
                        
                        
                             a b c d a b e a b c f
                        LPS  0 0 0 0 1 2 0 1 2 3 0
                                                 |
                                                index
                             
                             len = 3
                
                            
                            if the prefix last char is equal
                                len++;
                                lps[index] = len
                                index++
                            else
                                
                                if len == 0
                                    lps[index] = 0
                                    index++
                                else
                                    len = lps[len - 1]
                        
                    
                    
    Pattern Matching	
    		               
            
             a b c u i o p m y e d a b e a b c f
                   i
        
             a b c d a b e a b c f
        LPS  0 0 0 0 1 2 0 1 2 3 0
                   j
                   
                   
            str[i] ! = pattern [j]		
    		        then move index j to pattern of LIC | pie table index i.e	pattern [ j ]  (2)
                        
            
        */
        
        int n = s1.length();
        int m = s2.length();
        
        int k = (n + m - 1) / n;
        
        if(checkStringExistKTimes(s1, s2, k)) {
            return k;
        }
        
        if(checkStringExistKTimes(s1, s2, k + 1)) {
            return k + 1;
        }
        
        return -1;
    }
};