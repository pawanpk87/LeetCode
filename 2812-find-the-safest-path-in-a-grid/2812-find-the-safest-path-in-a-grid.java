class Solution {
    private boolean isPossible(int[][] manhattanDist, int safenessFactor){
        int n = manhattanDist.length;
    
        if(manhattanDist[0][0] < safenessFactor ||
           manhattanDist[n-1][n-1] < safenessFactor){
            return false;
        }
        
        Queue<int[]> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        bfs.add(new int[]{0, 0});
        visited[0][0] = true;
        
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        
        while(!bfs.isEmpty()){
            int[] currNode = bfs.poll();
            if(currNode[0] == n-1 && currNode[1] == n-1){
                return true;
            }
            for(int k = 0; k < 4; k++){
                int nextRow = dx[k] + currNode[0];
                int nextCol = dy[k] + currNode[1];
                if(isValidStep(nextRow, nextCol, n, n) && 
                   !visited[nextRow][nextCol] &&
                   manhattanDist[nextRow][nextCol] >= safenessFactor){
                    visited[nextRow][nextCol] = true;
                    bfs.add(new int[]{nextRow, nextCol});
                }
            }
        }
        
        return false;    
    }
    
    private int maximumSafenessFactorUtil(int[][] manhattanDist){
        if(manhattanDist[0][0] == 0){
            return 0;
        }
        
        int n = manhattanDist.length;
        int ans = -1;
        int left = 0, right =  0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                right = Math.max(right, manhattanDist[i][j]);
            }
        }         
        
        while(left <= right){
            int safenessFactor = (left + right) / 2;
            boolean result = isPossible(manhattanDist, safenessFactor);
            //System.out.println("safenessFactor: " + safenessFactor + " result:" + result);
            if(result){
                ans = safenessFactor;
                left = safenessFactor + 1;
            } else{
                right = safenessFactor - 1;
            }
        }
        
        return ans;
    }
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        int[][] manhattanDist = getManhattanDist(grid);
        
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(manhattanDist[i][j] + " ");
        //     }
        //     System.out.println();
        // }        
        
        return maximumSafenessFactorUtil(manhattanDist);
    }
    
    private int[][] getManhattanDist(List<List<Integer>> grid){
        int n = grid.size();
        
        int[][] manhattanDist = new int[n][n];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(manhattanDist[i], -1);
        }
        
        Queue<Integer[]> bfs = new LinkedList<Integer[]>();
            
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    manhattanDist[i][j] = 0;
                    bfs.add(new Integer[]{i, j, i, j});
                }
            }
        }
        
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        
        int nextRow, nextCol;
        int x1, y1, x2, y2;
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size-- > 0){
                Integer[] currNode = bfs.poll();
                for(int k = 0; k < 4; k++){
                    nextRow = dx[k] + currNode[0];
                    nextCol = dy[k] + currNode[1];
                    if(isValidStep(nextRow, nextCol, n, n)){
                        if(manhattanDist[nextRow][nextCol] == -1){
                            x1 = nextRow; y1 = nextCol;
                            x2 = currNode[2]; y2 = currNode[3];

                            manhattanDist[nextRow][nextCol] = getDist(x1, y1, x2, y2);

                            bfs.add(new Integer[]{nextRow, nextCol, x2, y2});
                        }
                    }
                }
            }
        }
        
        return manhattanDist;
    }
    
    public int getDist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    
    public boolean isValidStep(int i, int j, int n, int m){
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}