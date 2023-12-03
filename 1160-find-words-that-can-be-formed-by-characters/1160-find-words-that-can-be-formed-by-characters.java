class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsFreq = new HashMap<>();
        Map<Character, Integer> wordsFreq = new HashMap<>();
        calculateFreq(chars, charsFreq);
        int totalLen = 0;
        for(String word : words){
            calculateFreq(word, wordsFreq);
            boolean isValid = true;
            for(Map.Entry<Character, Integer> data : wordsFreq.entrySet()){
                if(data.getValue() > charsFreq.getOrDefault(data.getKey(), -1)){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                totalLen += word.length();
            }
            wordsFreq.clear();
        }
        return totalLen;
    }
    
    private void calculateFreq(String word, Map<Character, Integer> freq){
        int n = word.length();
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
    }
}