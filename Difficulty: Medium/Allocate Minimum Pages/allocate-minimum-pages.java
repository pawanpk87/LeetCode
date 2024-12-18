//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private static boolean isOk(int[] arr, int maxPages, int k) {
        int stuCount = 1;
        int currPages = 0;
        
        for(int num : arr) {
            currPages += num;
            
            if(currPages > maxPages) {
                stuCount++;
                currPages = num;
            }
            
            if(stuCount > k) {
                return false;
            }
        }
        
        return stuCount > k ? false : true;
    }
    
    public static int findPages(int[] arr, int k) {
        if(k > arr.length) {
            return -1;
        }
        
        int minNumPages = -1;
        
        long low = 0, high = 0;
        for(int num : arr) {
            low = Math.max(low, num);
            high += num;
        }
        
        if(arr.length == 1) {
            return (int) high;
        }
        
        while(low <= high) {
            int mid = (int) (low + high)/2;
            
            if(isOk(arr, mid, k)) {
                minNumPages = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return minNumPages;
    }
}