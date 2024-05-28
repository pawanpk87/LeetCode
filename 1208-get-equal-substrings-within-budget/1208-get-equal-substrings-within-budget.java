class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        
        int i = 0, j = 0;
        int maxLen = 0;
        
        while(j < n){
            maxCost -= Math.abs(getAscii(s.charAt(j)) -  getAscii(t.charAt(j)));
            
            while(maxCost < 0){
                maxCost += Math.abs(getAscii(s.charAt(i)) -  getAscii(t.charAt(i)));
                i++;
            }
            
            if(maxCost >= 0){
                maxLen = Math.max(maxLen, j - i + 1);
            }
            
            j++;
        }
        
        return maxLen;
    }
    
    private int getAscii(char ch){
        return ch - 'a';
    }
}