class Point {
    public int row;
    public int col;
    
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        Queue<Point> bfs = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    bfs.add(new Point(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{ 1, -1, 0, 0};
        
        while(!bfs.isEmpty()){
            int l = bfs.size();
            while(l-- > 0) {
                Point p = bfs.poll();
                for(int k = 0; k < 4; k++) {
                    int nextRow = p.row + dr[k];
                    int nextCol = p.col + dc[k];
                    
                    if(isValidPoint(nextRow, nextCol, n, m) && 
                       mat[nextRow][nextCol] == -1){
                        mat[nextRow][nextCol] = mat[p.row][p.col] + 1;
                        bfs.add(new Point(nextRow, nextCol)); 
                    }
                }
            }
        }
        
        return mat;
    }
    
    private boolean isValidPoint(int row, int col, int n, int m) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}