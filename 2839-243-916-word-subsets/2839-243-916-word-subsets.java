class Solution {
    public static int ALPHABET_SIZE = 26;

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bWordCharMaxFreq = getCharFreq("");

        for(String b : words2) {
            int[] freq = getCharFreq(b);
            for(int i = 0; i < ALPHABET_SIZE; i++) {
                bWordCharMaxFreq[i] = Math.max(bWordCharMaxFreq[i], freq[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for(String a : words1) {
            int[] freq = getCharFreq(a);
            boolean isValid = true;

            for(int i = 0; i < ALPHABET_SIZE; i++) {
                if(freq[i] < bWordCharMaxFreq[i]) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                res.add(a);
            }
        }

        return res;
    }

    private int[] getCharFreq(String word) {
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        return freq;
    }
}