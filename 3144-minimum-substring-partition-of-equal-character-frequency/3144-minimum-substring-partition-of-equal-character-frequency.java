class Solution {
    int[] memo;
    
    private int solve(int start, String s, int n){
        if(start >= n){
            return 0;
        }
        
        if(memo[start] != -1){
            return memo[start];
        }
        
        int minPartitions = Integer.MAX_VALUE;
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        
        for(int i = start; i < n; i++){
            freq[(s.charAt(i) - 'a')]++;
            if(isBalanced(freq)){
                int currPartitions = solve(i+1, s, n);
                if(currPartitions != -1){
                    minPartitions = Math.min(minPartitions, 1 + currPartitions);
                }
            }
        }
        
        return memo[start] = (minPartitions == Integer.MAX_VALUE ? -1 : minPartitions);
    }
    
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        return solve(0, s, s.length());
    }
    
    public boolean isBalanced(int[] freq){
        int maxFreq = 0;
        int minFreq = 1001;
        
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                maxFreq = Math.max(maxFreq, freq[i]);
                minFreq = Math.min(minFreq, freq[i]);
            }
        }
        
        return maxFreq == minFreq ? true : false;
    }
}