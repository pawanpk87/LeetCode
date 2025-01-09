//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
         /*
            
            1.) find a continuous subarray (a contiguous sequence of elements) 
                whose sum equals a specified value target.
        
            2.) need to return 1 based indices
            
            
            
            ex1:
                arr[] = [1, 2, 3, 7, 5], target = 12
                            |     |
                         
                    
                    sum = 1 + 2 + 3 + 7
                
                
            ex2:
                
                arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
                         |           |
                
                
                
                sum = 1 + 2 + 3 + 4 + 5
            
            
            
            
        Solutions1:
            
                arr[] = [1, 2, 3, 7, 5], target = 12
                            |
                                  |
                         
                
                sum = 2 + 3 + 7
                
                    
            
        
        */
        int n = arr.length;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        long sum = 0;
        
        while(j < n) {
            sum += arr[j];
            
            while(sum > target) {
                sum -= arr[i];
                i++;
            }
            
            if(sum == target) {
                res.add(i + 1);
                res.add(j + 1);
                return res;
            }
            
            j++;
        }
        
        res.add(-1);
        
        return res;
    }
}
