class Solution {

	public int countServers(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
        
		boolean[][] visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
                    connectWithOtherServers(i, j, visited, grid);
                }
            }
        }

        int servers = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) {
                    servers++;
                }
            }
        }

		return servers;
	}
    
    private void connectWithOtherServers(int row, int col, boolean[][] visited, int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		
		boolean isServerPresent = false;
		
		for(int i = col + 1; i < m; i++) {
			if(grid[row][i] == 1) {
				if(!visited[row][i]) {
					visited[row][i] = true;
					connectWithOtherServers(row, i, visited, grid);
				}
				isServerPresent = true;
			}
		}

		for(int i = row + 1; i < n; i++) {
			if(grid[i][col] == 1) {
                if(!visited[i][col]) {
                    visited[i][col] = true;
				    connectWithOtherServers(i, col, visited, grid);
                }
				isServerPresent = true;
			}
		}
		
		if(isServerPresent) {
			visited[row][col] = true;
		}
	}
}