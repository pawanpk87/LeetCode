class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        
        Map<String, Integer> freq = new HashMap<>();
        for(int i = 0; i < n; i += k){
            String currStr = word.substring(i, i + k);
            freq.put(currStr, freq.getOrDefault(currStr, 0) + 1);
        }
        
        int maxFreq = Integer.MIN_VALUE;
        int sum = 0;
        for(Integer data : freq.values()){
            maxFreq = Math.max(maxFreq, data);
            sum += data;
        }
        
        return sum - maxFreq;
    }
}