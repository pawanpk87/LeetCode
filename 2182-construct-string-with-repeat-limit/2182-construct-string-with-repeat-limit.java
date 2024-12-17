class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        
        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int index = 25;
        
        while(index >= 0) {
            if(count[index] > 0) {
                int appendChar = Math.min(count[index], repeatLimit);
                
                for(int i = 0; i < appendChar; i++) {
                    sb.append((char)('a' + index));
                    count[index]--;
                }
            
                if(count[index] > 0) {
                    char diffChar = getDiffChar(count, index - 1);

                    if(diffChar == '#') {
                        break;
                    }

                    sb.append(diffChar);
                    
                    count[diffChar - 'a']--;
                }
            } else {
                index--;
            }
        }
        
        return sb.toString();
    }
    
    private char getDiffChar(int[] count, int index) {
        for(int i = index; i >= 0; i--) {
            if(count[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return '#';
    }
}
/*
    
        s = "cczazcc", repeatLimit = 3
        
        s = "zzcccca"
        
        [1, 0, 4, 0, 0, 0, 0, ..., 2]
         a  b  c  d  e  f  g       z
                                   index
                                   
         
        if count[index] < repeatLimit
            take all the chars chars[index]
            index--;
        else 
            take repeatLimit number of chars 
            diffChar = getNextChar

        
        
        
*/