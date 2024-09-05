class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        
        int u,v;
        for(int[] edge : edges) {
            u = edge[0]; v = edge[1];
            indegree[v]++;
        }

        int champion = -1;
        int minIndegree = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(minIndegree > indegree[i]) {
                minIndegree = indegree[i];
                champion = i;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(champion == i) {
                continue;
            }
            
            if(indegree[i] <= minIndegree) {
                return -1;
            }
        }
        
        return champion;
    }
}