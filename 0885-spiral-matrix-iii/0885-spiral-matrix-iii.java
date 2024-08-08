class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dir = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        
        int[][] traversed = new int[rows * cols][2];
        
        int index = 0;
        
        for(int step = 1, direction = 0; index < rows * cols; step++) {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < step; j++) {
                    if(rStart >= 0 && cStart >= 0 &&
                       rStart < rows && cStart < cols) {
                        traversed[index][0] = rStart;
                        traversed[index][1] = cStart;
                        index++;
                    }
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }
                direction = (direction + 1) % 4;
            }
        }
        
        return traversed;
    }
}