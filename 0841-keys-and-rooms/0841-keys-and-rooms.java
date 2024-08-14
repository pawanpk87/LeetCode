class Solution {
    private void dfs(int currNode, List<List<Integer>> rooms, boolean[] visited) {
        visited[currNode] = true;
        for(int adjNode : rooms.get(currNode)) {
            if(visited[adjNode] == false) {
                dfs(adjNode, rooms, visited);
            }
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        boolean[] visited = new boolean[n];
        
        dfs(0, rooms, visited);
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                return false;
            }
        }
        
        return true;
    }
}