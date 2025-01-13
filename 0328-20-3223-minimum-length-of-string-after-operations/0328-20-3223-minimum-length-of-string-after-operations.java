class Solution {
    public static final int ALPHABET_COUNT = 26;

    int minimumLength(String str) {
        int n = str.length();
        
        if(n <= 2) {
            return n;
        }
        
        int[] freq = new int[ALPHABET_COUNT];
        for(char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        int shortedStrLen = 0;
    
        for(int f : freq) {
            int count = f - 1;
            if(count > 1) {
                int rem = count % 2;
                shortedStrLen += count - rem;
            }
        }
        
        return n - shortedStrLen;
    }
}