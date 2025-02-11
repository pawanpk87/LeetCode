class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjList = constructAdjList(n, connections);

        int minReorder = 0;

        Queue<Integer> bfsQ = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        bfsQ.add(0);
        visited.add(0);

        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while(size-- > 0) {
                int currNode = bfsQ.poll();
                
                int u, v;
                for(int[] adjNode : adjList.get(currNode)) {
                    u = adjNode[0]; v = adjNode[1];

                    if(currNode == u && !visited.contains(v)) {
                        minReorder += 1;
                        bfsQ.add(v);
                        visited.add(v);
                    }

                    if(currNode == v && !visited.contains(u)) {
                        bfsQ.add(u);
                        visited.add(u);
                    }
                }
            }
        }

        return minReorder;
    }

    private List<List<int[]>> constructAdjList(int n, int[][] connections) {
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }       

        int u, v;
        for(int[] connection : connections) {
            u = connection[0]; v = connection[1];
            adjList.get(u).add(connection);
            adjList.get(v).add(connection);
        }

        return adjList;
    }
}