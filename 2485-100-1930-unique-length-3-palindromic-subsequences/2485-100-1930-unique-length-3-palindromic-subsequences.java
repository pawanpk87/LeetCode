class Solution {
    public static final int ALPHABET_COUNTS = 26;

    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        int[] firstIndex = new int[ALPHABET_COUNTS];
        int[] lastIndex = new int[ALPHABET_COUNTS];

        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);

        for(int i = 0; i < n; i++) {
            int asciiVal = s.charAt(i) - 'a';
            
            if(firstIndex[asciiVal] == -1) {
                firstIndex[asciiVal] = i;
            }
            
            lastIndex[asciiVal] = i;
        }

        int totalPalindrome = 0;

        for(int ch = 0; ch < ALPHABET_COUNTS; ch++) {
            int i = firstIndex[ch];
            int j = lastIndex[ch];

            Set<Character> uniqueChars = new HashSet<>();

            for(int k = i + 1; k < j; k++) {
                uniqueChars.add(s.charAt(k));
            }

            totalPalindrome += uniqueChars.size();
        }

        return totalPalindrome;
    }
}