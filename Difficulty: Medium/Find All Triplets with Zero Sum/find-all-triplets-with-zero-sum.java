//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;

        Map<Integer, List<List<Integer>>> sum = new HashMap<>();
    
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum.putIfAbsent(arr[i] + arr[j], new ArrayList<>());
                sum.get(arr[i] + arr[j]).add(Arrays.asList(i, j));
            }
        }
    
        Set<List<Integer>> res = new HashSet<>();
    
        for (int i = 0; i < n; i++) {
            int target = -arr[i];
            if (sum.containsKey(target)) {
                for (List<Integer> pair : sum.get(target)) {
                    if (pair.get(0) != i && pair.get(1) != i) {
                        List<Integer> triplet = Arrays.asList(i, pair.get(0), pair.get(1));
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                }
            }
        }
    
        return new ArrayList<>(res);
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends