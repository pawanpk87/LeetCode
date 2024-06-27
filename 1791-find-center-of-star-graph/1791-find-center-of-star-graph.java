class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        
        int[] outdegree = new int[n];
        
        int u, v;
        for(int[] edge : edges){
            u = edge[0] - 1;
            v = edge[1] - 1;
            outdegree[u]++;
            outdegree[v]++;
        }
        
        for(int i = 0; i < n; i++){
            if(outdegree[i] == n-1){
                return i+1;
            }
        }
        
        return -1;
    }
}