class Solution {
    private static final int MOD = 1000000007;
    int memo[][][];
    
    private boolean isValid(int i, int j, int chess[][], int n, int m){
        return (i >= 0 && j >= 0 && i < n && j < m && chess[i][j] >= 0) ? true : false;
    }
    
    private int count(int i, int j, int steps, int chess[][], int n, int m){
        if(isValid(i, j, chess, n, m) == true){
            if(steps == 0){
                return 1;
            }
            
            if(memo[i][j][steps] != -1){
                return memo[i][j][steps];
            }
            
            int tempCount1 = (
            count(i-2, j-1, steps-1, chess, n, m) + 
                count(i-2, j+1, steps-1, chess, n, m) +
                count(i+2, j-1, steps-1, chess, n, m) +
                count(i+2, j+1, steps-1, chess, n, m)) % MOD;
            
            int tempCount2 = (
                count(i-1, j-2, steps-1, chess, n, m) +
                count(i+1, j-2, steps-1, chess, n, m) +
                count(i-1, j+2, steps-1, chess, n, m) +
                count(i+1, j+2, steps-1, chess, n, m)
            )%MOD;
            
            
            return memo[i][j][steps] = ( tempCount1 + tempCount2 ) % MOD;
        }else{
            return 0;
        }
    }
    
    public int knightDialer(int steps) {
        int n = 4, m = 3;
        int chess[][] = new int[n][m];
        memo = new int[n][m][5001];
        for(int i = 0; i < n; i++){
            Arrays.fill(chess[i], 0);
            for(int j = 0; j < m; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        chess[3][0] = chess[3][2] = -1;
        
        int totalCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                totalCount = (totalCount + count(i, j, steps-1, chess, n, m)) % MOD;
            }
        }
        
        return totalCount;
    }
}