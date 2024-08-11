class Solution {
    int count = 0;
    
    private int dfs(int currNode, List<List<Integer>> adjList, boolean[] visited) {
        visited[currNode] = true;
        
        boolean flag = true;
        
        int size = 0;
        
        int prevSize = -1;
        
        for(int adjNode : adjList.get(currNode)) {
            if(visited[adjNode] == true) {
                continue;
            }
            
            int currSize = dfs(adjNode, adjList, visited);
            
            if(prevSize == -1) {
                prevSize = currSize;
            } else {
                if(prevSize != currSize) {
                    flag = false;
                }
            }
            
            size += currSize;
        }
        
        if(flag) {
            count++;
        } 
        
        return 1 + size;
    }
    
    public int countGoodNodes(int[][] edges) {
        count = 0;
        int n = edges.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < (n+1); i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        
        dfs(0, adjList, visited);
        
        return count;
    }
}
/*

    0 -> 6, 0
    1 -> 0, 5, 3
    5 -> 1 , 2
    2 -> 5
    3 -> 1, 4
    4 -> 3
    6 -> 0
    
    
    
    


*/