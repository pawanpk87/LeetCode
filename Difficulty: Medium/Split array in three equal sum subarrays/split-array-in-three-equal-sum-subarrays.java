//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        int n = arr.length;
        
        long[] suffSum = new long[n];
        
        for(int i = n - 1; i >= 0; i--) {
            if(i == n-1) {
                suffSum[i] = arr[i];
            } else {
                suffSum[i] = suffSum[i + 1] + arr[i];
            }
        }
        
        long firstPartSum = 0;
        
        for(int i = 0; i < n - 2; i++) {
            firstPartSum = firstPartSum + arr[i];
            
            if((firstPartSum * 2) == suffSum[i + 1]) {
                long secondPartSum = firstPartSum;
                
                int index = findSum(secondPartSum, suffSum, i + 1, n - 1);
                
                if(index != -1) {
                    return Arrays.asList(i, index - 1);
                }
            }
        }
        
        return Arrays.asList(-1, -1);
    }
    
    private int findSum(long targetSum, long[] arr, int l, int r) {
        int resIndex = -1;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(arr[mid] > targetSum) {
                l = mid + 1;
            } else if (arr[mid] < targetSum ) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        
        return resIndex;
    }
}