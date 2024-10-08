class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCharsFreq = new HashMap<>();
        
        for(char ch : t.toCharArray()) {
            tCharsFreq.put(ch, tCharsFreq.getOrDefault(ch, 0) + 1);
        }
        
        int n = s.length();
        
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        
        int count = tCharsFreq.size();
        int i = 0, j = 0;
        
        while(j < n) {
            char currChar = s.charAt(j);
            
            if(tCharsFreq.containsKey(currChar)) {
                tCharsFreq.put(currChar, tCharsFreq.get(currChar) - 1);
                
                if(tCharsFreq.get(currChar) == 0) {
                    count--;
                }
            }
            
            while(count == 0) {
                if(minLen > (j - i + 1)) {
                    startIndex = i;
                    minLen = (j - i + 1);
                }
                
                currChar = s.charAt(i);
                
                if(tCharsFreq.containsKey(currChar)) {
                    tCharsFreq.put(currChar, tCharsFreq.get(currChar) + 1);
                    if(tCharsFreq.get(currChar) == 1) {
                        count++;
                    }
                }
                
                i++;
            }
            
            j++;
        }
        
        if(startIndex == -1) {
            return "";
        }
        
        return s.substring(startIndex, startIndex + minLen);
    }
}