//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        Map<Integer, Integer> freq = new HashMap<>();
        int i = 0, j = 0;
        
        while(j < n) {
            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);
            
            while((j - i + 1) > k) {
                freq.put(arr[i], freq.get(arr[i]) - 1);
                
                if(freq.get(arr[i]) == 0) {
                    freq.remove(arr[i]);
                }
                
                i++;
            }
            
            if((j - i + 1) == k) {
                res.add(freq.size());
            }
            
            j++;
        }
        
        return res;
    }
}