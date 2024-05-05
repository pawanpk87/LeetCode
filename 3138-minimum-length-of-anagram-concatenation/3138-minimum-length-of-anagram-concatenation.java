class Solution {
    private boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        
        if(n != m){
            return false;
        }
        
        Map<Character, Integer> freq = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < m; i++){
            char ch = t.charAt(i);
            if(freq.containsKey(ch)){
                int f = freq.get(ch) - 1;
                if(f == 0){
                    freq.remove(ch);
                } else{
                    freq.put(ch, f);
                }
            } else{
                return false;
            }
        }
        
        return freq.size() == 0;
    }
    
    private boolean check(int k, String s){
        int n = s.length();
        
        if(n%k != 0){
            return false;
        }
        
        String baseStr = s.substring(0, k);
        
        for(int i = k; i < n; i += k){
            String currStr = s.substring(i, i + k);
            if(isAnagram(baseStr, currStr) == false){
                return false;
            }
        }
        
        return true;
    }
    
    public int minAnagramLength(String s) {
        int n = s.length();
        for(int i = 1; i <= n; i++){
            if(check(i, s)){
                return i;
            }
        }
        return -1;
    }
}