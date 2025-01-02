class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;

        int[] res = new int[m];


        int[] prefSum = new int[n];
        prefSum[0] = isValidWord(words[0]) ? 1 : 0;
        for(int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + (isValidWord(words[i]) ? 1 : 0);
        }

        int start, end;
        for(int i = 0; i < m; i++) {
            start = queries[i][0]; end = queries[i][1];
            res[i] = prefSum[end] - (start - 1 >= 0 ? prefSum[start - 1] : 0);
        }

        return res;
    }

    private boolean isValidWord(String word) {
        int n = word.length();

        Set<Character> vowelLetters = 
            Stream.of('a', 'e', 'i', 'o', 'u')
                     .collect(Collectors.toSet());
        
        return vowelLetters.contains(word.charAt(0)) &&
                vowelLetters.contains(word.charAt(n - 1));
    }
}