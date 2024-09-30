class CustomStack {
    int[] arr;
    int maxSize;
    int size;
    int frontPtr;
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        
        this.size = 0;
        this.frontPtr = -1;
        
        this.arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(isFull()) {
            return;
        }
        frontPtr++;
        arr[frontPtr] = x;
        size++;
    }
    
    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int val = arr[frontPtr];
        frontPtr--;
        size--;
        return val;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(size, k); i++) {
            arr[i] = arr[i] + val;
        }
    }
    
    private boolean isEmpty() {
        return size == 0;    
    }
    
    private boolean isFull() {
        return size == maxSize;
    }
}
/*

    maxSize = 3
    size = 2
    frontPtr = 1
    
  [201, 202, 103]
              |
             fp
     
 
    push:
        if the stack is not full then put the 
            val in the current frontPtr
        if not then do nothing
        
    pop
        if stack is empty then return -1
        if not then return the element present at the
        current frontPtr
    
    increment
        iteratr from i = 0 to min(size, k)
            and then crements the val of the cell arr[i]
             
*/