//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		
System.out.println("~");
}
} }
// } Driver Code Ends


class Solution{
    static void quickSort(int arr[], int low, int high){
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            
            quickSort(arr, low, pivotIndex - 1);
            
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    static int partition(int arr[], int low, int high){
        // pick the pivot
        int pivot = arr[high];
        
        int index = low - 1;
        
        for(int j = low; j <= high; j++) {
            if(arr[j] < pivot) {
                index++;
                swap(arr, index, j);
            }
        }
        
        swap(arr, index + 1, high);
        
        return index + 1;
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
