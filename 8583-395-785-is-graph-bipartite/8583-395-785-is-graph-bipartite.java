class Solution {
    private boolean fillColor(int currNode, int currColor, List<List<Integer>> adjList, int[] color) {
        color[currNode] = currColor;

        for(int adjNode : adjList.get(currNode)) {
            if(color[adjNode] == -1) {
                if(!fillColor(adjNode, currColor == 0 ? 1 : 0, adjList, color)) {
                    return false;
                }
            } else if(color[adjNode] == currColor) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adjList = constructAdjList(graph);

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int node = 0; node < n; node++) {
            if(color[node] == -1) {
                if(!fillColor(node, 0, adjList, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<List<Integer>> constructAdjList(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int u = 0; u < n; u++) {
            for(int v : graph[u]) {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }

        return adjList;
    }
}