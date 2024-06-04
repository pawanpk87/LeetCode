class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        
        Map<Character, Integer> freq = new HashMap<>();
        IntStream.range(0, n)
            .forEach(i -> freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1));
        
        int count = 0;
        int isOddPalindrome = 0;
        for(Integer c : freq.values()){
            int rem = c%2;
            count += (c - rem);
            if(rem != 0) isOddPalindrome = 1;
        }
        
        return count + isOddPalindrome;
    }
}