class Solution {
    private int solve(int currIndex, String[] words, int[] alphabetFreq, int[] score){
        int n = words.length;
        
        if(currIndex == n){
            return 0;
        }    
        
        int maxScore = 0;
        
        for(int i = currIndex; i < n; i++){
            boolean isValid = true;
            int currWordScore = 0;
            
            for(char ch : words[i].toCharArray()){
                alphabetFreq[(ch - 'a')]--;
                currWordScore += score[(ch - 'a')];
                if(alphabetFreq[(ch - 'a')] < 0){
                    isValid = false;
                }
            }
            
            if(isValid){
                maxScore = Math.max(maxScore, currWordScore + solve(i + 1, words, alphabetFreq, score));
            } 
            
            for(char ch : words[i].toCharArray()){
                alphabetFreq[(ch - 'a')]++;
            }
        }
        
        return maxScore;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] alphabetFreq = new int[26];
        
        for(int i = 0; i < letters.length; i++){
            alphabetFreq[(letters[i] - 'a')]++;
        }
        
        return solve(0, words, alphabetFreq, score);
    }
}