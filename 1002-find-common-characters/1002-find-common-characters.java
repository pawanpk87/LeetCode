class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        
        int[] freq = getFrequence(words[0]);
        
        for(int i = 1; i < n; i++){
            int[] currStrFreq = getFrequence(words[i]);
            for(int k = 0; k < 26; k++){
                freq[k] = Math.min(freq[k], currStrFreq[k]);
            }
        }
        
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            while(freq[i]-- > 0){
                char ch = (char)('a' + i);
                res.add(String.valueOf(ch));
            }
        }
        
        return res;
    }
    
    public int[] getFrequence(String word){
        int n = word.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            freq[(ch - 'a')]++;
        }
        return freq;
    }
}