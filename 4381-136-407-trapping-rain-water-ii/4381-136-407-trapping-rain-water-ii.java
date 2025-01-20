class Cell implements Comparable<Cell> {
    int height;
    int row;
    int col;

    public Cell(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }

    public int compareTo(Cell other) {
        return Integer.compare(this.height, other.height);
    }
}

class Solution {
    int[] dx = new int[] {-1, 1, 0, 0};
    int[] dy = new int[] {0, 0, -1, 1};

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    minHeap.add(new Cell(heightMap[i][j], i, j));
                    visited[i][j] = true;
                }
            }
        }

        int water = 0;

        while(!minHeap.isEmpty()) {
            Cell currCell = minHeap.poll();

            int currHeight = currCell.height;
            int row = currCell.row;
            int col = currCell.col;

            for(int k = 0; k < 4; k++) {
                int nrow = row + dx[k];
                int ncol = col + dy[k];

                if(isValidCell(nrow, ncol, n, m) && !visited[nrow][ncol]) {
                    int nheight = heightMap[nrow][ncol];
                    if(nheight < currHeight) {
                        water += currHeight - nheight;
                    }

                    minHeap.add(
                        new Cell(Math.max(nheight, currHeight), nrow, ncol)
                    );
                    visited[nrow][ncol] = true;
                }
            }
        }

        return water;
    }

    private boolean isValidCell(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}