class TreeAncestor {
    int maxPow;
    int[][] jump;
    
    public TreeAncestor(int n, int[] parent) {
        maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
        
        jump = new int[maxPow][n];
        
        jump[0] = parent;
        
        for(int p = 1; p < maxPow; p++) {
            for(int node = 0; node < n; node++) {
                jump[p][node] = jump[p - 1][node] == -1 ? -1 : jump[p - 1][jump[p - 1][node]];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int p = maxPow - 1; p >= 0; p--) {
            if((1 << p) <= k) {
                node = jump[p][node];
                
                if(node == -1) {
                    return -1;
                }
                
                k -= (1 << p);
            }
        }
        
        return node;
    }
}