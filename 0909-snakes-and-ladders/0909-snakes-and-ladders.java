class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        bfs.add(1);
        visited.add(1);
        
        int moves = 0;
        
        while(!bfs.isEmpty()) {
            int s = bfs.size();
            while(s-- > 0) {
                int currSqr = bfs.poll();
                
                if(currSqr == (n*n)) {
                    return moves;
                }
                
                for(int k = 1; k <= 6; k++) {
                    int nextSqr = Math.min(currSqr + k, n*n);
                    
                    int[] coordinates = getCoordinates(nextSqr, n);
                    
                    int r = coordinates[0], c = coordinates[1];
                    
                    if(board[r][c] != -1) {
                        nextSqr = board[r][c];
                    }
                    
                    if(visited.contains(nextSqr) == false) {
                        visited.add(nextSqr);
                        bfs.add(nextSqr);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
    
    private int[] getCoordinates(int num, int n) {
        int[] corrdinates = new int[2];
        
        int row = n-1-(num-1)/n;
        int col = (num-1)%n;

        if((n-1-row)%2 != 0){
           col= n-1-col;
        } 
            
        corrdinates[0] = row;
        corrdinates[1] = col;
        
        return corrdinates;
    }
}