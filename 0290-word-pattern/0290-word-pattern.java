class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        
        String[] words = s.split(" ");
        
        if(words.length != n){
            return false;
        }
        
        Map<Character, Integer> patternIndex = new HashMap<>();
        Map<String, Integer> wordsIndex = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            Integer prevIndexOfChar = patternIndex.put(pattern.charAt(i), i);
            Integer prevIndexOfS = wordsIndex.put(words[i], i);
            
            if(Objects.equals(prevIndexOfChar, prevIndexOfS) == false){
                return false;
            }
        }
        
        return true;
    }
}