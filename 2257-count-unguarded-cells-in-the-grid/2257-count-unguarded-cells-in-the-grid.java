class Solution {
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int[][] grid = new int[n][m];
        
        int r,c;
        
        for(int[] guard : guards) {
            r = guard[0];
            c = guard[1];
            
            grid[r][c] = 1;
        }
        
        for(int[] wall : walls) {
            r = wall[0];
            c = wall[1];
            
            grid[r][c] = -1;
        }
        
        for(int[] guard : guards) {
            r = guard[0];
            c = guard[1];
            
            guardNow(r, c, grid, n, m);
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void guardNow(int row, int col, int[][] guards, int n, int m) {
        for(int j = col + 1; j < m; j++) {
            if(guards[row][j] == -1 || guards[row][j] == 1) {
                break;
            }
            guards[row][j] = Integer.MAX_VALUE;
        }
        
        for(int j = col - 1; j >= 0; j--) {
            if(guards[row][j] == -1 || guards[row][j] == 1) {
                break;
            }
            guards[row][j] = Integer.MAX_VALUE;
        }
        
        for(int i = row + 1; i < n; i++) {
            if(guards[i][col] == -1 || guards[i][col] == 1) {
                break;
            }
            guards[i][col] = Integer.MAX_VALUE;
        }
        
        for(int i = row - 1; i >= 0; i--) {
            if(guards[i][col] == -1 || guards[i][col] == 1) {
                break;
            }
            guards[i][col] = Integer.MAX_VALUE;
        }
    }
}