class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] resMatrix = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                resMatrix[j][i] = matrix[i][j];
            }
        }
        return resMatrix;
    }
}