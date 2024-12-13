class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }    
        });
        
        for(int i = 0; i < n; i++) {
            minHeap.add(new int[]{nums[i], i});
        }
        
        boolean[] marked = new boolean[n];
        long score = 0;
        
        while(!minHeap.isEmpty()) {
            int num = minHeap.peek()[0];
            int index = minHeap.peek()[1];
            
            minHeap.remove();

            if(marked[index] == false) {
                score += num;
                marked[index] = true;
                
                if(index - 1 >= 0) {
                    marked[index - 1] = true;
                } 
                
                if(index + 1 < n) {
                    marked[index + 1] = true;
                }
            }
        }
        
        return score;
    }
}