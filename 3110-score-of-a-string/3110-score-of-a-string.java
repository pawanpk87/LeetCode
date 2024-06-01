class Solution {
    public int scoreOfString(String s) {
        int n = s.length();
        int score = 0;
        for(int i = 1; i < n; i++){
            score += Math.abs(s.charAt(i-1) - s.charAt(i));
        }
        return score;
    }
}