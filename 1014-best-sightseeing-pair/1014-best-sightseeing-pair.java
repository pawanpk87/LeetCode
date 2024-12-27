class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        
        int[] maxJ = new int[n];
        maxJ[n - 1] = values[n - 1] - (n - 1);
        for(int i = n - 2; i >= 0; i--) {
            maxJ[i] = Math.max(values[i] - i, maxJ[i + 1]);
        }
        
        int maxScore = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++) {
            maxScore = Math.max(maxScore, values[i] + i + maxJ[i + 1]);
        }
        
        return maxScore;
    }
}