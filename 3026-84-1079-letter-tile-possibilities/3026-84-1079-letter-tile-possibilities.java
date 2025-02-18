class Solution {
    public static final int ALPHABET_SIZE = 26;

    private int generateSequences(int[] freq) {
        int count = 0;
        
        for(int i = 0; i < ALPHABET_SIZE; i++) {
            if(freq[i] > 0) {
                count++;

                freq[i]--;
                count += generateSequences(freq);
                freq[i]++;
            }
        }

        return count;
    }

    public int numTilePossibilities(String tiles) {
        int[] freq = new int[ALPHABET_SIZE];

        for(char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        return generateSequences(freq);    
    }
}
