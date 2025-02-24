class Solution {

    private void dfs(
        int currNode, 
        int currDist, 
        int parentNode, 
        List<List<Integer>> adjList, 
        int[] parent, 
        int[] dist
    ) {
        parent[currNode] = parentNode;
        dist[currNode] = currDist;

        for(int adjNode : adjList.get(currNode)) {
            if(adjNode != parentNode) {
                dfs(adjNode, currDist + 1, currNode, adjList, parent, dist);
            }
        }
    }

    private int getMaxAmount(int currNode, int parentNode, List<List<Integer>> adjList, int[] amount) {
        int maxAmont = Integer.MIN_VALUE;

        for(int adjNode : adjList.get(currNode)) {
            if(adjNode != parentNode) {
                maxAmont = Math.max(maxAmont, getMaxAmount(adjNode, currNode, adjList, amount));
            }
        }

        if(maxAmont == Integer.MIN_VALUE) {
            return amount[currNode];
        }

        return amount[currNode] + maxAmont;
    }

    private List<List<Integer>> constructAdjList(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int u,v;
        for(int[] edge : edges) {
            u = edge[0]; v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;

        List<List<Integer>> adjList = constructAdjList(edges);

        int[] parent = new int[n];
        int[] dist = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(dist, -1);

        dfs(0, 0, -1, adjList, parent, dist);

        int currNode = bob;
        int bobDist = 0;

        while(parent[currNode] != -1) {
            if(dist[currNode] > bobDist) {
                amount[currNode] = 0;
            } else if(dist[currNode] == bobDist) {
                amount[currNode] = amount[currNode]/2;
            }

            currNode = parent[currNode];
            bobDist++;
        }

        return getMaxAmount(0, -1, adjList, amount);
    }
}