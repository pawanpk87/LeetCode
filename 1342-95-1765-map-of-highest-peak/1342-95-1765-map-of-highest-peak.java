class Solution {
	public int[][] highestPeak(int[][] isWater) {
		int n = isWater.length;
		int m = isWater[0].length;
		
		int[][] height = new int[n][m];

		for(int i = 0; i < n; i++) {
			Arrays.fill(height[i], -1);
		}
		
		Queue<int[]> bfs = new LinkedList<>();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(isWater[i][j] == 1) {
					height[i][j] = 0;
					bfs.add(new int[]{i, j});
				}
			}
		}

		int[] dr = new int[] {1, -1, 0, 0};
		int[] dc = new int[] {0, 0, -1, 1};

		while(!bfs.isEmpty()) {
			int size = bfs.size();
			while(size-- > 0) {
				int r = bfs.peek()[0];
				int c = bfs.peek()[1];
				bfs.poll();
                
				for(int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(isValid(nr, nc, n, m) && height[nr][nc] == -1) {
						height[nr][nc] = height[r][c] + 1;
						bfs.add(new int[]{nr, nc});
					}
				}
			}
		}
		
		return height;
	}

	private boolean isValid(int r, int c, int n, int m) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
