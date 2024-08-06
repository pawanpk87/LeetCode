class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size()) {
            if(!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        } else {
            if(!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        }
    }
    
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if(size % 2 != 0) {
            return maxHeap.peek();
        } else {
            double num1 = (double) maxHeap.peek(); 
            double num2 = (double) minHeap.peek();
            return (num1 + num2)/2;
        }
    }
}