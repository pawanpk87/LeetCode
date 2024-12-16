class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
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
        
        while(k-- > 0) {
            int[] currNum = minHeap.poll();
            minHeap.add(new int[]{multiplier * currNum[0], currNum[1]});
        }
        
        while(!minHeap.isEmpty()) {
            int[] currNum = minHeap.poll();
            nums[currNum[1]] = currNum[0]; 
        }
        
        return nums;
    }
}