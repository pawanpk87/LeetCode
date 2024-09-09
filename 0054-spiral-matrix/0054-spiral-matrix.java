class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        List<Integer> res = new ArrayList<>();
        
        int lColLimit = 0, rColLimit = m - 1;
        int uRowLimit = 0, dRowLimit = n - 1;
        
        while(lColLimit <= rColLimit && uRowLimit <= dRowLimit) {
            for(int j = lColLimit; j <= rColLimit; j++) {
                res.add(matrix[uRowLimit][j]);
            }
            
            uRowLimit++;
            
            for(int i = uRowLimit; i <= dRowLimit; i++) {
                res.add(matrix[i][rColLimit]);
            }
            rColLimit--;
            
            if(uRowLimit <= dRowLimit) {
                for(int j = rColLimit; j >= lColLimit; j--) {
                    res.add(matrix[dRowLimit][j]);
                }
                dRowLimit--;
            }
        
            if(lColLimit <= rColLimit) {
                for(int i = dRowLimit; i >= uRowLimit; i--) {
                    res.add(matrix[i][lColLimit]);
                }
                lColLimit++;
            }
        }
        
        return res;
    }
}
/*

    n m
    
    rColLimit  lColLimit
    dRowLimit  uRowLimit
   
    
        j = currCol  to rColLimit
        
        currRow++
        
        if currRow <= dRowLimit
            i = currRow to dRowLimit
        
        
        currCol--;
        
        if currCol >= lColLimit
            j = currCol to lColLimit
        
        currRow--;
        
        if currRow >= uRowLimit
            i = currRow to uRowLimit
        
        
        
        rColLimit--;
        lColLimit++;
        dRowLimit--;
        uRowLimit++;
        

*/