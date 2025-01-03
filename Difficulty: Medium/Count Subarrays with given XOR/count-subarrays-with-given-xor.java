//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        long subarrays = 0;
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        freq.put(0, 1);
        
        int xorNum = 0;
        for(int num : arr) {
            xorNum = xorNum ^ num;
            
            int targetNum = xorNum ^ k;
            
            if(freq.containsKey(targetNum)) {
                subarrays += freq.get(targetNum);
            }
            
            freq.put(xorNum, freq.getOrDefault(xorNum, 0) + 1);
        }
        
        return subarrays;
    }
}
/*

    1.) count the number of subarrays having XOR of their elements as k.
    
    
    xor:- 
    
        1 ^ 1 = 0
        0 ^ 1 = 1
        0 ^ 0 = 0
        1 ^ 0 = 1
        
    
        arr[] = [4, 2, 2, 6, 4], k = 6
                             
                 4  6  4  2  6
                             |
             
        mp = {
          0 -> 1
          4 -> 2
          6 -> 1
          2 -> 1
        }
        
        count = 1 + 2 + 1
        
        
        
    
    0010
    0100
    0110
    
    
    
    0001 1
    0010 2
    0011 3
    0100 4
    0101 5
    0110 6
    0111 7
    
    
*/