class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int rowCount[] = new int[n];
        int colCount[] = new int[m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    if(rowCount[i] == 1 && colCount[j] == 1){
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}