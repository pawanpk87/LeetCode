//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int circularSubarraySum(int arr[]) {
        int maxSumSoFar = Integer.MIN_VALUE, minSumSoFar = Integer.MAX_VALUE;
        int sumSoFar = 0, minSum = 0;
        int totalSum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sumSoFar = Math.max(sumSoFar + arr[i], arr[i]);
            maxSumSoFar = Math.max(maxSumSoFar, sumSoFar);
            
            minSum = Math.min(minSum + arr[i], arr[i]);
            minSumSoFar = Math.min(minSumSoFar, minSum);
            
            totalSum += arr[i];
        }
        
        return maxSumSoFar > 0 ? Math.max(maxSumSoFar, totalSum - minSumSoFar) : maxSumSoFar;
    }
}
