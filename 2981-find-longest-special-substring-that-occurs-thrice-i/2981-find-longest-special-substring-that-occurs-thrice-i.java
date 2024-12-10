class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        
        Map<String, Integer> mp = new HashMap<>();
        
        for(int k = 0; k < n; k++) {
            StringBuilder sb = new StringBuilder();
            for(int index = k; index < n; index++) {
                if(sb.length() > 0 &&
                     sb.charAt(sb.length() - 1) != s.charAt(index)) {
                    break;
                }

                sb.append(s.charAt(index));

                mp.put(
                    sb.toString(), 
                    mp.getOrDefault(sb.toString(), 0) + 1
                );
            }
        }
        
        int maxLen = -1;
        for(Map.Entry<String, Integer> data : mp.entrySet()) {
            if(data.getValue() >= 3 && 
                    maxLen < data.getKey().length()) {
                maxLen = data.getKey().length();
            }
        }
        
        
        return maxLen;
    }
}