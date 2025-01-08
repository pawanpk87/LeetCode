class Solution {
    private boolean isPrefixAndSuffix(String targetText, String word) {
        int n = targetText.length();
        int m = word.length();
        
        if(n > m) {
            return false;
        }
        
        return word.substring(0, n).equals(targetText) 
                && word.substring(m - n).equals(targetText);
    }
    
    public int countPrefixSuffixPairs(String[] words) {
        int n  = words.length;
        
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(words[i].length() > words[j].length()) {
                    continue;
                }
                
                if(isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}