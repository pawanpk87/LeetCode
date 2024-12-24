class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            adjList.put(i, new HashSet<>());
        }
        
        int u,v;
        for(int[] edge : edges) {
            u = edge[0]; v = edge[1];
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        Queue<Integer> bfs = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(adjList.get(i).size() <= 1) {
                bfs.add(i);
            }
        }
        
        while(n > 2) {
            int size = bfs.size();
            n -= size;
            while(size-- > 0) {
                int currNode = bfs.poll();
                for(int adjNode : adjList.get(currNode)) {
                    adjList.get(adjNode).remove(currNode);
                    if(adjList.get(adjNode).size() == 1) {
                        bfs.add(adjNode);
                    }
                }
            }
        }
        
        while(!bfs.isEmpty()) {
            res.add(bfs.poll());
        }    
        
        return res;
    }
}