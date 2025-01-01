//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, ArrayList<String>> mp = new TreeMap<>();
        
        for(String word : arr) {
            String sortedStr = sortStr(word);
            mp.putIfAbsent(sortedStr, new ArrayList<>());
            mp.get(sortedStr).add(word);
        }
        
        ArrayList<ArrayList<String>> res = new ArrayList();
        
        for(ArrayList<String> words : mp.values()) {
            res.add(words);
        }
        
        return res;
    }
    
    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends