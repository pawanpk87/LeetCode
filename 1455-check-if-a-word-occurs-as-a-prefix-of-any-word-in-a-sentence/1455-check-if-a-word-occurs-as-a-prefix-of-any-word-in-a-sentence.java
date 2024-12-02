class Solution {
    private boolean isPrefix(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        int i = 0;
        int j = 0;
        
        while(i < n && j < m && str1.charAt(i) == str2.charAt(j)) {
            i++;
            j++;
        }
        
        return j == m;
    }
    
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        
        for(int i = 0; i < words.length; i++) {
            if(searchWord.length() <= words[i].length() && 
               isPrefix(words[i], searchWord)) {
                return i + 1;
            }
        }
        
        return -1;
    }
}