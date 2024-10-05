class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freq = new HashMap<>();
        
        for(char ch : s1.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        int n = s2.length();
        int i = 0, j = 0;
        int count = freq.size();
        
        while(j < n) {
            if(freq.containsKey(s2.charAt(j))) {
                int f = freq.get(s2.charAt(j));
                freq.put(s2.charAt(j), f-1);
                if(f == 1) {
                    count--;
                }
            }
            
            if((j - i + 1) > s1.length()) {
                if(freq.containsKey(s2.charAt(i))) {
                    int f = freq.get(s2.charAt(i));
                    freq.put(s2.charAt(i), f + 1);
                    if(f == 0) {
                        count++;
                    }
                }
                i++;
            }
            
            if((j - i + 1) == s1.length() && count == 0) {
                return true;
            }
            
            j++;
        }
        
        return false;
    }
}