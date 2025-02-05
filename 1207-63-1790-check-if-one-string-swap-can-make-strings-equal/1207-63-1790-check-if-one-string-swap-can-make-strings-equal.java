class Solution {
    public static int ALPHABET_SIZE = 26;

    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();

        int diffChars = 0;

        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diffChars++;
            }
        }

        return diffChars <= 2 && haveSameFrequency(s1, s2);
    }

    private boolean haveSameFrequency(String s1, String s2) {
        int[] freq = new int[ALPHABET_SIZE];

        for(char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch : s2.toCharArray()) {
            freq[ch - 'a']--;
        }

        for(int i = 0; i < ALPHABET_SIZE; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}