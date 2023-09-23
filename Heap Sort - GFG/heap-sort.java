//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends

class MinHeap{
    private List<Integer> heap;
    private Integer capacity;
    private Integer size;

    MinHeap(Integer capacity){
        heap = new ArrayList<Integer>(capacity);
        this.capacity = capacity;
        this.size = 0;

        for(int i = 0; i <= capacity; i++){
            heap.add(0);
        }
    }
    
    public void printHeap(){
        System.out.println("list is");
        for(int i = 0; i < size; i++){
            System.out.print(heap.get(i)+" ");   
        }
    }

    private Integer getParentIndex(Integer index){
        return (index - 1)/2;
    }

    private Integer getLeftChildIndex(Integer index){
        return 2*index + 1;
    }

    private Integer getRightChildIndex(Integer index){
        return 2*index + 2;
    }

    public void swap(List<Integer> heap, Integer i, Integer j){
        Integer temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapify(Integer index){
        int maxIndex = index;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if(leftChildIndex < size && heap.get(leftChildIndex) <= heap.get(maxIndex)){
            maxIndex = leftChildIndex;
        }

        if(rightChildIndex < size && heap.get(rightChildIndex) <= heap.get(maxIndex)){
            maxIndex = rightChildIndex;
        }

        if(maxIndex != index){
            swap(heap, maxIndex, index);
            heapify(maxIndex);
        }
    }

    public void insert(Integer num){
        if(size == capacity){
            System.out.println("Heap is full, unable to insert");
            return;
        }

        heap.set(size++, num);

        // Maintain the heap property
        Integer index = size - 1;
        while(size > 0 && heap.get(index) < heap.get(getParentIndex(index))){
            swap(heap, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public Integer getMin(){
        if(size == 0){
            System.out.println("Heap is empty!");
            return -1;
        }

        Integer minNum = heap.get(0);

        heap.set(0, heap.get(size - 1));

        size--;

        // Maintin the heap property
        heapify(0);

        return minNum;
    }
}


class Solution
{
    public void heapSort(int arr[], int n){
        MinHeap heap = new MinHeap(n);
        for(int i = 0; i < n; i++){
            heap.insert(arr[i]);
        }
        
        for(int i = 0; i < n; i++){
            arr[i] = heap.getMin();
        }
    }
 }
 
 
