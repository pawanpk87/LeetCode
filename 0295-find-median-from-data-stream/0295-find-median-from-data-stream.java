class MedianFinder {
    private Queue<Long> minHeap = new PriorityQueue<>();
    private Queue<Long> maxHeap = new PriorityQueue<>();
    
    public void addNum(int num) {
        maxHeap.add((long)num);
        minHeap.add(-maxHeap.poll());
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(-minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? 
                    maxHeap.peek() :
                        (maxHeap.peek() - minHeap.peek()) / 2.0;
    }
}