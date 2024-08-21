class Solution {
    int count = 0;
    
    void generatePalindrome(String str, int i, int j) {
        while(i >= 0 && j < str.length()) {
            if(str.charAt(i) != str.charAt(j)) {
                break;
            }
            count++;
            i--;
            j++;
        }
    }
    
    public int countSubstrings(String str) {
        int n = str.length();
        
        for(int i = 0; i < n; i++) {
            generatePalindrome(str, i, i);
            generatePalindrome(str, i-1, i);
        }
        
        return count;
    }
}