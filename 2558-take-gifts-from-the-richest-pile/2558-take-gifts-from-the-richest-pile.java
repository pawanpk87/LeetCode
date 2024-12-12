class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int gift : gifts) {
            maxHeap.add(gift);
        }
        
        while(k-- > 0) {
            int num = maxHeap.poll();
            maxHeap.add((int)Math.sqrt(num));
        }
        
        long res = 0;
        
        while(!maxHeap.isEmpty()) {
            res += maxHeap.poll();
        }
        
        return res;
    }
}