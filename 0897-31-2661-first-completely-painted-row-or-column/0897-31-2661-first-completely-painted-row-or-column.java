class Solution {
	public int firstCompleteIndex(int[] arr, int[][] mat) {
		int n = arr.length;
		
		int row = mat.length;
		int col = mat[0].length;
		
		int[] rowFreq = new int[row];
		int[] colFreq = new int[col];
		
		Map<Integer, int[]> mp = new HashMap<>();

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
                mp.put(mat[i][j], new int[]{i, j});
            }
        }

        for(int i = 0; i < n; i++) {
            int[] index = mp.get(arr[i]);
            int r = index[0];
            int c = index[1];

            rowFreq[r]++;
            colFreq[c]++;

            if(rowFreq[r] == col) return i;
            if(colFreq[c] == row) return i;
        }

        return -1;
    }
}