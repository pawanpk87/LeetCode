class Solution {
    private boolean validPalindromeUtil(String s, int i, int j, int k){
        if(i < j){
            if(s.charAt(i) == s.charAt(j)){
                return validPalindromeUtil(s, i+1, j-1, k);
            } else if(k == 0){
                return validPalindromeUtil(s, i+1, j, k + 1) || 
                       validPalindromeUtil(s, i, j-1, k + 1); 
            } else{
                return false;
            }
        } else{
            return true;
        }
    }
    
    public boolean validPalindrome(String s) {
        return validPalindromeUtil(s, 0, s.length() - 1, 0);
    }
}