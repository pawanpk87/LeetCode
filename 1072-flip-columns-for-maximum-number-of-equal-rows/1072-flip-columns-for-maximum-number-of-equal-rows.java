class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int maxRows = 0;
        
        for(int i = 0; i < n; i++) {
            int[] flippedValues = new int[m];
            
            for(int j = 0; j < m; j++) {
                flippedValues[j] = 1 - matrix[i][j];
            }
            
            int currMaxRows = 0;
            
            for(int j = i; j < n; j++) {
                if(Arrays.equals(matrix[j], matrix[i]) ||
                   Arrays.equals(matrix[j], flippedValues)) {
                    currMaxRows++;
                }
            }
            
            maxRows = Math.max(maxRows, currMaxRows);
        }
        
        return maxRows;
    }
}