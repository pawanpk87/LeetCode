class Num implements Comparable<Num> {
    int row;
    int col;
    int val;
    
    public Num(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
    
    @Override
    public int compareTo(Num other) {
        return this.val - other.val;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        PriorityQueue<Num> minHeap = new PriorityQueue<>();
        
        for(int j = 0; j < n; j++) {
            minHeap.add(new Num(0, j, matrix[0][j]));
        }
        
        // min1 {min2 , m3}
        for(int i = 0; i < k-1; i++) {
            Num curr = minHeap.poll();
            
            int row = curr.row;
            int col = curr.col;
            
            if(row == n-1) continue;
            
            minHeap.add(new Num(row + 1, col, matrix[row+1][col]));
        }
        
        return minHeap.poll().val;
    }
}