class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int maxArea = 0;
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(matrix[row][col] == 1 && row > 0){
                    matrix[row][col] += matrix[row - 1][col];
                }
            }
            int currRow[] = matrix[row].clone();
            Arrays.sort(currRow);           
            for(int i = 0; i < m; i++){
                maxArea = Math.max(maxArea, ((m - i) * currRow[i]));
            }
        }
        
        return maxArea;
    }
}