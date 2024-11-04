class Solution {
    public String compressedString(String word) {
        int n = word.length();
        
        StringBuilder compressedStr = new StringBuilder();
        
        char prevChar = word.charAt(0);
        int prevCharCount = 1;
        
        for(int i = 1; i < n; i++) {
            if(prevCharCount < 9 && prevChar == word.charAt(i)) {
                prevCharCount++;
            } else {
                compressedStr.append((char)(prevCharCount + '0'));
                compressedStr.append(prevChar);
                
                prevChar = word.charAt(i);
                prevCharCount = 1;
            }
        }
        
        compressedStr.append((char)(prevCharCount + '0'));
        compressedStr.append(prevChar);
        
        return compressedStr.toString();
    }
}