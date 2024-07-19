class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        Map<Integer, Integer> rowMax = new HashMap<>();
        Map<Integer, Integer> colMin = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                rowMax.put(i, Math.min(rowMax.getOrDefault(i, Integer.MAX_VALUE), matrix[i][j]));
                colMin.put(j, Math.max(colMin.getOrDefault(j, Integer.MIN_VALUE), matrix[i][j]));
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rowMax.get(i) == matrix[i][j] && matrix[i][j] == colMin.get(j)) {
                    res.add(matrix[i][j]);
                }
            }
        }
        
        return res;
    }
}