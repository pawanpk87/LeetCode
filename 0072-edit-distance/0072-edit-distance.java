class Solution {
    int[][] memo;
    
    private int solve(int i, int j, String word1, String word2, int  n, int m) {
        if(i == n || j == m) {
            if(i == n && j == m) {
                return 0;
            }
            if(i == n && j != m) {
                return (m - j);
            } else {
                return (n - i);
            }
        }
        
        if(memo[i][j] != -1){
            return memo[i][j]; 
        }
        
        if(word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = solve(i + 1, j + 1, word1, word2, n, m);
        } else {
            // Insert a char
            int pos1 = 1 + solve(i, j + 1, word1, word2, n, m);
            
            // Delete a char
            int pos2 = 1 + solve(i + 1, j, word1, word2, n, m);
            
            // Repla a char
            int pos3 = 1 + solve(i + 1, j + 1, word1, word2, n, m);
            
            return memo[i][j] = Math.min(pos1, Math.min(pos2, pos3));
        }
    }
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        memo = new int[n+1][m+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return solve(0, 0, word1, word2, n, m);
    }
}