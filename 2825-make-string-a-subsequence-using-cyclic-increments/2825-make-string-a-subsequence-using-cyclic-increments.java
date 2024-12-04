class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            if(str1.charAt(i) == str2.charAt(j) ||
               nextChar(str1.charAt(i)) == str2.charAt(j)) {
                j++;
            }
            i++;
        }
        
        return j == m;
    }
    
    private char nextChar(char ch) {
        return (char) ('a' + ((ch - 'a') + 1) % 26);
    }
}