class Solution {
    private final int[][] directions = {
        { 1, 3 },
        { 0, 2, 4 },
        { 1, 5 },
        { 0, 4 },
        { 3, 5, 1 },
        { 4, 2 },
    };
    
    public int slidingPuzzle(int[][] board) {
        StringBuilder boardState = new StringBuilder();
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                boardState.append(board[i][j]);
            }
        }
        
        Map<String, Integer> visitedState = new HashMap<>();
        
        dfs(boardState.toString(), boardState.indexOf("0"), 0, visitedState);
        
        return visitedState.getOrDefault("123450", -1);
    }
    
    private void dfs(String currState, int zeroPos, int moves, Map<String, Integer> visited) {
        if(visited.containsKey(currState) && visited.get(currState) < moves) {
            return;
        }
        
        visited.put(currState, moves);
        
        for(int nextPos : directions[zeroPos]) {
            String newState = swap(currState, zeroPos, nextPos);
            dfs(newState, nextPos, moves + 1, visited);
        }
    }
    
    private String swap(String state, int pos1, int pos2) {
        StringBuilder updatedState = new StringBuilder(state);
        updatedState.setCharAt(pos1, state.charAt(pos2));
        updatedState.setCharAt(pos2, state.charAt(pos1));
        return updatedState.toString();
    }
}