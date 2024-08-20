class Solution {
    int[][][] memo;
    
    private int stoneGameUtil(int index, int m, int isAliceTurn, int[] piles) {
        if(index == piles.length) {
            return 0;
        }   
        
        if(memo[index][m][isAliceTurn] != -1) {
            return memo[index][m][isAliceTurn];
        }
        
        if(isAliceTurn == 0) {
            int aliceMaxProfit = 0;
            int currSum = 0;
            for(int i = index, c = 1; i < piles.length &&  c <= (2*m); i++, c++) {
                currSum += piles[i];
                aliceMaxProfit = Math.max(aliceMaxProfit, 
                                          currSum + stoneGameUtil(i+1, Math.max(m, c), 1, piles));
            }
            return memo[index][m][isAliceTurn] = aliceMaxProfit;
        } else {
            int aliceMinProfit = Integer.MAX_VALUE;
            for(int i = index, c = 1; i < piles.length &&  c <= (2*m); i++, c++) {
                aliceMinProfit = Math.min(aliceMinProfit, 
                                          stoneGameUtil(i+1, Math.max(m, c), 0, piles));
            }
            
            return memo[index][m][isAliceTurn] = aliceMinProfit;
        }
    }
    
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        memo = new int[101][101][2];
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                for(int k = 0; k < 2; k++) {
                    memo[i][j][k] = -1;
                }
            }  
        }
        
        return stoneGameUtil(0, 1, 0, piles);
    }
} 