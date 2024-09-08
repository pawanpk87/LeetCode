class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        
        return maxHeap.poll();
    }
}