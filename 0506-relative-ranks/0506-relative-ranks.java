class Solution {
    private String getRank(int score){
        if(score == 1){
            return "Gold Medal";
        } else if(score == 2){
            return "Silver Medal";
        } else if(score == 3){
            return "Bronze Medal";
        } else{
            return String.valueOf(score);
        }
    }
    
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        
        int[] tempScore = Arrays.copyOf(score, n);
        Arrays.sort(tempScore);
        
        Map<Integer, String> rankMapper = new HashMap<>();
        for(int i = n-1, num = 1; i >= 0; i--, num++){
            rankMapper.put(tempScore[i], getRank(num));
        }
        
        String[] ranks = new String[n];
        IntStream.range(0, n)
            .forEach(i -> ranks[i] = rankMapper.get(score[i]));
        
        return ranks;
    }
}