//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    Set<String> st = new HashSet<>();
    
    void generatePalindrome(String str, int i, int j) {
        while(i >= 0 && j < str.length()) {
            if(str.charAt(i) != str.charAt(j)) {
                break;
            }
            st.add(str.substring(i, j+1));
            i--;
            j++;
        }
    }
    
    int palindromeSubStrs(String str) { 
        int n = str.length();
        
        for(int i = 0; i < n; i++) {
            generatePalindrome(str, i, i);
            generatePalindrome(str, i-1, i);
        }
        
        return st.size();
    }
}

/*
    
        
    
        
    
    

*/