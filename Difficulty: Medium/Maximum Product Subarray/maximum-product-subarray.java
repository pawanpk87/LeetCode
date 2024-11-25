//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        
        int maxProd = arr[0];
        
        int positiveProd = arr[0];
        int negativeProd = arr[0];
        
        for(int i = 1; i < n; i++) {
            if(arr[i] < 0) {
                int temp = positiveProd;
                positiveProd = negativeProd;
                negativeProd = temp;
            }
            
            positiveProd = Math.max(arr[i], arr[i] * positiveProd);
            negativeProd = Math.min(arr[i], arr[i] * negativeProd);
            
            maxProd = Math.max(maxProd, positiveProd);
        }
        
        return maxProd;
    }
}