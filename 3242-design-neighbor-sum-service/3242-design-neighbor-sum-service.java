class neighborSum {
    int[][] grid;
    Map<Integer, int[]> index;
    int n,m;
    
    public neighborSum(int[][] grid) {
        index = new HashMap<>();
        
        n = grid.length;
        m = grid[0].length;
        
        this.grid = grid;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                index.put(grid[i][j], new int[]{i, j});
            }
        }
    }
    
    public int adjacentSum(int value) {
        int i = index.get(value)[0];
        int j = index.get(value)[1];
        
        int sum = 0;
        
        int[] mr = new int[] {0, 0, -1, 1};
        int[] mc = new int[] {-1, 1, 0, 0};
        
        int ni, nj;
        for(int k = 0; k < 4; k++) {
            ni = i + mr[k];
            nj = j + mc[k];
            if(isValid(ni, nj, n, m)) {
                sum += grid[ni][nj];
            }
        }
        
        return sum;
    }
    
    public int diagonalSum(int value) {
        int i = index.get(value)[0];
        int j = index.get(value)[1];
        
        int sum = 0;
        
        int[] mr = new int[] {-1, -1, 1, 1};
        int[] mc = new int[] {-1, 1, -1, 1};
        
        int ni, nj;
        for(int k = 0; k < 4; k++) {
            ni = i + mr[k];
            nj = j + mc[k];
            if(isValid(ni, nj, n, m)) {
                sum += grid[ni][nj];
            }
        }
        
        return sum;
    }
    
    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 &&
               i < n && j < m;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */