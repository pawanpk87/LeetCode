class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size(), m = grid.get(0).size();
        
        int[][] ans = new int[n][m];
        
        ans[n-1][m-1] = grid.get(n-1).get(m-1);
        for(int j = m-2; j >= 0; j--){
            ans[n-1][j] = Math.max(grid.get(n-1).get(j), ans[n-1][j+1]);
        }
        for(int i = n-2; i >= 0; i--){
            ans[i][m-1] = Math.max(grid.get(i).get(m-1), ans[i+1][m-1]);
        }
        
        for(int i = n-2; i >= 0; i--){
            for(int j = m-2; j >= 0; j--){
                ans[i][j] = Math.max(grid.get(i).get(j), Math.max(ans[i+1][j], ans[i][j+1]));
            }
        }
        
        int count = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i+1 < n){
                    count = Math.max(count, ans[i+1][j] - grid.get(i).get(j));
                }
                if(j+1 < m){
                    count = Math.max(count, ans[i][j+1] - grid.get(i).get(j));
                }
            }
        }
        
        return count;
    }
}