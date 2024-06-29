class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        int[] indegree = new int[n];
        int u,v;
        for(int[] edge : edges){
            u = edge[0];
            v = edge[1];
            adjList.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> bfs = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                bfs.add(i);
            }
        }
        
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        
        while(!bfs.isEmpty()){
            int currNode = bfs.poll();
            for(int adjNode : adjList.get(currNode)){
                Set<Integer> st = new HashSet<>(mp.getOrDefault(currNode, new HashSet<Integer>()));
                st.add(currNode);

                addToNode(adjNode, st, mp);

                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    bfs.add(adjNode);
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(new ArrayList(mp.getOrDefault(i, new HashSet<>())));
            Collections.sort(res.get(i));
        }
        
        return res;
    }
    
    void addToNode(int node, Set<Integer> st, Map<Integer, Set<Integer>> mp){
        Set<Integer> prevSt = mp.getOrDefault(node, new HashSet<Integer>());
        for(int ancestor : st){
            prevSt.add(ancestor);
        }
        mp.put(node, prevSt);
    }
}