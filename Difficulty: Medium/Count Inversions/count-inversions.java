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
            System.out.println(new Solution().inversionCount(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int mergeArr(int[] arr, int left, int mid, int right) {
        int n = right - left + 1;
        int[] sortedArr = new int[n];

        int leftArrNumsCount = mid - left + 1;
        int k = 0;
        int inversions = 0;
        int i = left, j = mid + 1;

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                sortedArr[k] = arr[i];
                i++;
            } else {
                sortedArr[k] = arr[j];
                inversions += (mid - i + 1);
                j++;
            }
            k++;
        }

        while(i <= mid) {
            sortedArr[k] = arr[i];
            k++;
            i++;
        }

        while(j <= right) {
            sortedArr[k] = arr[j];
            k++;
            j++;
        }

        k = 0;
        for(int index = left; index <= right; index++) {
            arr[index] = sortedArr[k++];
        }

        return inversions;
    }

    private static int countInversions(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            
            int count = 0;
            
            count += countInversions(arr, left, mid);
            count += countInversions(arr, mid + 1, right);
            
            count += mergeArr(arr, left, mid, right);
            
            return count;
        } else {
            return 0;
        }
    }
    
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int inversions = countInversions(arr, 0, n-1);
        return inversions;
    }
}