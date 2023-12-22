class Solution {
    public int maxScore(String s) {
        int n = s.length();
        
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        
        int ones = 0, zeros = 0;
        
        for(int i = 0, j = n-1; i < n; i++, j--){
            zeros += s.charAt(i) - '0' == 0 ? 1 : 0;
            ones += s.charAt(j) - '0' == 1 ? 1 : 0;
            
            prefix[i] = zeros;
            suffix[j] = ones;
        }
        
        int maxScore = 0;
        
        for(int i = 1; i < n; i++){
            maxScore = Math.max(maxScore, prefix[i-1] + suffix[i]);
        }
        
        return maxScore;
    }
}