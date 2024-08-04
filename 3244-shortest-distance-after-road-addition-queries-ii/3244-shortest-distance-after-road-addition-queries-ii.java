class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        var result = new int[queries.length];
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 1; i < n; i++) {
            mp.put(i-1, i);
        }
        
        for(int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if(!mp.containsKey(u)) {
                result[i] = mp.size();
                continue;
            }
            
            int nodeToBeDeleted = mp.get(u);
            while(nodeToBeDeleted < v) {
                nodeToBeDeleted = mp.remove(nodeToBeDeleted);
            }
            
            mp.put(u, v);
            
            result[i] = mp.size();
        }
        
        return result;
    }
}