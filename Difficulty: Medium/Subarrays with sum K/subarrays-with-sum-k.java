//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubarrays(int arr[], int k) {
        int subarrays = 0;
        
        Map<Long, Integer> freq = new HashMap<>();
        
        freq.put(0L, 1);
        
        long sum = 0;
        for(int num : arr) {
            sum += num;
            
            long targetNum = sum - k;
            
            if(freq.containsKey(targetNum)) {
                subarrays += freq.get(targetNum);
            }
            
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        
        return subarrays;
    }
}