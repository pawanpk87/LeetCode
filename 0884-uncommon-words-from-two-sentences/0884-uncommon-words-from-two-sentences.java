class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> freq = new HashMap<>();
        
        String[] words = s1.split(" ");
        
        for(String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        words = s2.split(" ");
        
        for(String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        List<String> res = new ArrayList<>();
        
        for(Map.Entry<String, Integer> data : freq.entrySet()) {
            if(data.getValue() == 1) {
                res.add(data.getKey());
            }
        }
        
        return res.toArray(new String[0]);
    }
}