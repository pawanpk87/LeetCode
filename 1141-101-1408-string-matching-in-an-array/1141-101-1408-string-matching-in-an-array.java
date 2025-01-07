class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int[] lps = constructLPS(words[i]);

            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                if(isSubstringOf(words[j], words[i], lps)) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }

    private int[] constructLPS(String str) {
        int n = str.length();

        int[] lps = new int[n];

        lps[0] = 0;

        int len = 0;
        int i = 1;

        while(i < n) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }

    private boolean isSubstringOf(String text, String pattern, int[] patternLps) {
        int n = text.length();
        int m = pattern.length();

        int i = 0, j = 0;

        while(i < n) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if(j == m) {
                return true;
            } else if(i < n && text.charAt(i) != pattern.charAt(j)){
                if(j == 0) {
                    i++;
                } else {
                    j = patternLps[j - 1];
                }
            }
        }

        return false;
    }
}