class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int count = 0;
        for(int row = 0; row < n; row++){
            int[] h = new int[m];
            Arrays.fill(h, 1);
            for(int currRow = row; currRow < n; currRow++){
                for(int j = 0; j < m; j++){
                    h[j] &= mat[currRow][j];
                }
                count += cal(h);
            }
        }
        return count;
    }
    
    private int cal(int[] ones){
        int res = 0, length = 0;
        for(int i = 0; i < ones.length; i++){
            length = ones[i] == 0 ? 0 : length + 1;
            res += length;
        }
        return res;
    }
}