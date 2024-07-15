class Solution {
    private int [][][][] memo;
    
    private int minimumCostUtil(int hi, int hj, int[] horizontalCut, 
                                int vi, int vj, int[] verticalCut){
        if((hj - hi) == 1 && (vj - vi) == 1){
            return 0;
        }
        
        if(memo[hi][hj][vi][vj] != -1){
            return memo[hi][hj][vi][vj];
        }
        
        int currMinCost = Integer.MAX_VALUE;
        
        for(int i = hi + 1; i < hj; i++){
            int currCost = horizontalCut[i - 1];
            currCost += minimumCostUtil(hi, i, horizontalCut, vi, vj, verticalCut);
            currCost += minimumCostUtil(i, hj, horizontalCut, vi, vj, verticalCut);
            currMinCost = Math.min(currMinCost, currCost);
        }
        
        for(int i = vi + 1; i < vj; i++){
            int currCost = verticalCut[i - 1];
            currCost += minimumCostUtil(hi, hj, horizontalCut, vi, i, verticalCut);
            currCost += minimumCostUtil(hi, hj, horizontalCut, i, vj, verticalCut);
            currMinCost = Math.min(currMinCost, currCost);
        }
        
        return memo[hi][hj][vi][vj] = currMinCost;
    }
    
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        memo = new int[21][21][21][21];
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                for(int l = 0; l < 21; l++){
                    Arrays.fill(memo[i][j][l], -1);
                }
            }
        }
        return minimumCostUtil(0, m, horizontalCut, 0, n, verticalCut);
    }
}