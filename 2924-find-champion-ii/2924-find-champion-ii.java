class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        
        int u,v;
        for(int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            indegree[v]++;
        }
        
        int champion = -1;
        
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                if(champion != -1) {
                    return -1;
                }
                champion = i;
            }
        }
        
        return champion;
    }
}