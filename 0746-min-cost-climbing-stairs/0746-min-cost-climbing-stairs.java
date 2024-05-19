class Solution {
    int[] memo;
    
    private int solve(int[] cost, int index, int n){
        if(index >= n){
            return 0;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        int pos1 = solve(cost, index+1, n);
        int pos2 = solve(cost, index+2, n);
        
        return memo[index] = (cost[index] + Math.min(pos1, pos2));
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        int pos1 = solve(cost, 0, n);
        int pos2 = solve(cost, 1, n);
        
        return Math.min(pos1, pos2);
    }
}