class MyCircularQueue {
    int[] arr;
    int front, rear;
    int size;
    int capacity;
    
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        
        this.arr = new int[this.capacity];
        
        this.front = 0;
        this.rear = this.capacity - 1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        
        int nextIndex = (rear + 1) % capacity;
        arr[nextIndex] = value;
        rear = nextIndex;
        
        size++;
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        
        int nextFront = (front + 1) % capacity;
        front = nextFront;
        
        size--;
        
        return true;
    }
    
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}