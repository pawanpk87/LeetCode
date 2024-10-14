class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums) {
            maxHeap.add(num);
        }
        
        long maxNum = 0;
        
        while(!maxHeap.isEmpty() && k-- > 0) {
            int num = maxHeap.poll();
            
            maxNum += num;
            
            maxHeap.add((int) Math.ceil((double)num / 3));
        }
        
        return maxNum;
    }
}