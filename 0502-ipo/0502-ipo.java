class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] < b[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        
        for(int i = 0; i < n; i++) {
            capitalMinHeap.add(new int[]{capital[i], i});
        }
        
        PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if(a < b) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        
        while(k-- > 0) {
            while(!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= w) {
                int targetPofitIndex = capitalMinHeap.poll()[1];
                profitMaxHeap.add(profits[targetPofitIndex]);
            }
            if(profitMaxHeap.isEmpty()) {
                break;
            }
            w += profitMaxHeap.poll();
        }
        
        return w;
    }
}