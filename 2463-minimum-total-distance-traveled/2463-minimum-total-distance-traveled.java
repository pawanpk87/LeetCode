class Solution {
    private long[][] memo;
    
    private long solve(int rbtIndex, int fctIndex, List<Integer> robot, List<Integer> factories) {
        if(rbtIndex == robot.size()) {
            return 0;
        }
        
        if(fctIndex == factories.size()) {
            return (long) 1e12;
        }
        
        if(memo[rbtIndex][fctIndex] != -1) {
            return memo[rbtIndex][fctIndex];
        }
        
        long take = Math.abs(robot.get(rbtIndex) - factories.get(fctIndex)) 
                    + solve(rbtIndex + 1, fctIndex + 1, robot, factories);
        
        long notTake = solve(rbtIndex, fctIndex + 1, robot, factories);
        
        return memo[rbtIndex][fctIndex] = Math.min(take, notTake);
    }
    
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        
        Arrays.sort(factory, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        
        List<Integer> factories = new ArrayList<>();
        for(int[] f : factory) {
            for(int i = 0; i < f[1]; i++) {
                factories.add(f[0]);
            }
        }
        
        int n = robot.size();
        int m = factories.size();
        
        memo = new long[n][m];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return solve(0, 0, robot, factories);
    }
}