//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int equilibriumPoint(long arr[], int n) {
        if(n == 1)
            return 1;
        
        long sum[] = new long[n];
    
        sum[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            sum[i] = sum[i+1] + arr[i];
        }
        
        long currSum = arr[0];
        for(int i = 1; i < n-1; i++){
            if(currSum == sum[i+1]){
                return i+1;
            }
            currSum += arr[i];
        }
        
        return -1;
    }
}