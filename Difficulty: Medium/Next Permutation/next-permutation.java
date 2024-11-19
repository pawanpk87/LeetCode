//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        /*
            arr = [2, 4, 1, 7, 5, 0]
            
            nextPermutation: [2, 4, 5, 0, 1, 7]
            nextPermutation: [2, 4, 5, 0, 7, 1]
            nextPermutation: [2, 4, 5, 1, 0, 7]
            nextPermutation: [2, 4, 5, 1, 7, 0]
            nextPermutation: [2, 4, 5, 7, 0, 1]
            nextPermutation: [2, 4, 5, 7, 1, 0]
            ...
            
            
            [2, 4, 1, 7, 5, 0]
            
                    \
                      \
                        \
            
                ex  5 3 2
                    not possible to generate the next permutation
            
            
            
            ?
            [2, 4, 1, 7, 5, 0]
                   |
                   
                   swap with some number but with which number ?
                   
                        /
                      /
                    /
                  /
                  1 4 7  8
                
        */
        
        int n = arr.length;
        
        int index = n - 1;
        
        while(index > 0 && arr[index - 1] >= arr[index]) {
            index--;
        }
        
        if(index == 0) {
            reverse(arr, 0, n-1);
            return;
        }
        
        --index;
        
        int num = arr[index];
        int minNumIndex = -1;
        
        for(int i = index + 1; i < n; i++) {
            if(arr[i] > num) {
                minNumIndex = i;
            }
        }
        
        swap(arr, index, minNumIndex);
        
        reverse(arr, index + 1, n - 1);
    }
    
    private void reverse(int[] arr, int i, int j) {
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends