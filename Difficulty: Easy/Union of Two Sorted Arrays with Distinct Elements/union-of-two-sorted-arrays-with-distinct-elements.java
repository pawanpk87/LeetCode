//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int nums1[], int nums2[]) {
        int n = nums1.length;
        int m = nums2.length;
        
        ArrayList<Integer> resList = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            if(nums1[i] == nums2[j]) {
                i++;
            } else if(nums1[i] < nums2[j]) {
                resList.add(nums1[i]);
                i++;
            } else {
                resList.add(nums2[j]);
                j++;
            }
        }
        
        while(i < n) {
            while(i + 1 < n && nums1[i] == nums1[i + 1]) {
                i++;
            }
            
            resList.add(nums1[i]);
            
            i++;
        }
        
        while(j < m) {
            while(j + 1 < m && nums2[j] == nums2[j + 1]) {
                j++;
            }
            
            resList.add(nums2[j]);
            
            j++;
        }
        
        return resList;
    }
}
