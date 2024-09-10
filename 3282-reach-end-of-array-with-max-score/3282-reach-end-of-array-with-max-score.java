class Solution {
    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        
        long score = 0;
        
        int i = 0;
        long prevNum = nums.get(0);
        
        for(int j = 1; j < n; j++) {
            if(prevNum < nums.get(j)) {
                score += (j - i) * prevNum;
                i = j;
                prevNum = nums.get(j);
            }
        }
        
        score += (n-1 - i) * prevNum;
        
        return score;
    }
}