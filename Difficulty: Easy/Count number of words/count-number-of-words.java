//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.countWords(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution { 
    int countWords(String s) { 
        int n = s.length();
        
        int count = 0;
        int wordLen = s.charAt(0) >= 'a' && s.charAt(0) <= 'z' ? 1 : 0;
        
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == ' ' ||   
               (s.charAt(i-1) == '\\' && (s.charAt(i) == 'n' ||  s.charAt(i) == 't'))){
                   if(wordLen > 0) {
                       count++;
                   }
                   wordLen = 0;
            } else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                wordLen++;
            }
        }
        
        if(wordLen > 0) {
            count++;
        }
        
        return count;
    }
} 