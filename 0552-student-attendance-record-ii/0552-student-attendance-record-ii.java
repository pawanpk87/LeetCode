class Solution {
    public static int MOD = 1000000007;
    
    private int solve(int n, int totalAbsent, int currLate, int[][][] memo){
        if(n == 0){
            return 1;
        }    
        
        if(memo[n][totalAbsent][currLate] != -1){
            return memo[n][totalAbsent][currLate];
        }
        
        int pos1 = 0, pos2 = 0, pos3 = 0;
        
        if(totalAbsent < 1){
            pos1 = solve(n-1, totalAbsent + 1, 0, memo);
        }
        
        pos2 = solve(n-1, totalAbsent, 0, memo);
        
        if(currLate < 2){
            pos3 = solve(n-1, totalAbsent, currLate + 1, memo);
        }
        
        return memo[n][totalAbsent][currLate] = (((pos1 + pos2)%MOD) + pos3)%MOD;
    }
    
    public int checkRecord(int n) {
        int[][][] memo = new int[n+1][2][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        return solve(n, 0, 0, memo);
    }
}