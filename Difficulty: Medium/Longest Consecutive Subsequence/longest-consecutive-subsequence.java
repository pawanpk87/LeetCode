//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        if(n <= 1) {
            return n;
        }

        Arrays.sort(nums);
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxLen = 1;
        int currLen = 1;
        
        for(int i = n - 2; i >= 0; i--) {
            if((nums[i] + 1) == nums[i + 1]) {
                currLen++;
            } else if(nums[i] == nums[i + 1]){
                continue;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }
        
        maxLen = Math.max(maxLen, currLen);
        
        return maxLen;
    }
}