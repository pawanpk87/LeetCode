class Solution {
    private boolean isPrefix(String pref, String word) {
        return word.startsWith(pref);
    }

    public int prefixCount(String[] words, String pref) {
        int n = words.length;

        int prefixWordCount = 0;

        for(String word : words) {
            if(isPrefix(pref, word)) {
                prefixWordCount++;
            }
        }

        return prefixWordCount;
    }
}