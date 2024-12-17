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
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private static boolean isOk(int[] stalls, int dist, int k) {
        int n = stalls.length;
        
        int cowsCount = 1;
        int pos = stalls[0];
        int index = 1;
        
        while(index < n) {
            while(stalls[index] - pos >= dist) {
                cowsCount++;
                pos = stalls[index];
                if(cowsCount == k) {
                    return true;
                }
            }
            index++;
        }
        
        return false;
    }
    
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        
        Arrays.sort(stalls);
        
        int maxNum = stalls[n - 1] - stalls[0];
        
        int maxDist = 0;
        int low = 1, high = maxNum;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            if(isOk(stalls, mid, k)) {
                maxDist = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return maxDist;
    }
}