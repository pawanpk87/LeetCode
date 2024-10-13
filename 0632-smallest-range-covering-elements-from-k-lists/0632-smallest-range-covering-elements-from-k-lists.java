class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int maxValue = Integer.MIN_VALUE;
        int[] range = new int[]{0, Integer.MAX_VALUE};
        
        for(int i = 0; i < nums.size(); i++) {
            minHeap.add(new int[]{nums.get(i).get(0), i, 0});
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }
        
        while(minHeap.size() == nums.size()) {
            int[] data = minHeap.poll();
            
            int minNum = data[0];
            int kIndex = data[1];
            int numIndex = data[2];
            
            if((maxValue - minNum) < (range[1] - range[0])) {
                range[0] = minNum;
                range[1] = maxValue;
            }
            
            if(numIndex + 1 < nums.get(kIndex).size()) {
                minHeap.add(new int[]{nums.get(kIndex).get(numIndex + 1), kIndex, numIndex + 1});
                maxValue = Math.max(maxValue, nums.get(kIndex).get(numIndex + 1));
            }
        }
        
        return range;
    }
}