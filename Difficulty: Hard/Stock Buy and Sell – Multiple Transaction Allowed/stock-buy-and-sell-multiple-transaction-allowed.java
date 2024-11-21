//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    int[][] memo;
    
    private int maximumProfitUtil(int day, int turn, int[] prices) {
        if(day == prices.length) {
            return 0;
        }    
        
        if(memo[day][turn] != -1) {
            return memo[day][turn];
        }
        
        int pos1 = 0;
        int pos2 = 0;
        
        if(turn == 0) {
            pos1 = maximumProfitUtil(day + 1, 1, prices) - prices[day];
        } else {
            pos1 = maximumProfitUtil(day + 1, 0, prices) + prices[day];
        }
        
        pos2 = maximumProfitUtil(day + 1, turn, prices);
        
        return memo[day][turn] = Math.max(pos1, pos2);
    }
    
    public int maximumProfit(int prices[]) {
        /*
            
        prices[] = [100, 180, 260, 310, 40, 535, 695]
                     
                     |
                    
                    buy = 100
                    profit = 0
                    180, 260, 310, 40, 535, 695]
                     |
                 /  
              profit = 80
               260, 310, 40, 535, 695]
               |
              /
         buy = 260
         profit = 80
         310, 40, 535, 695]   
          |
           \
            
        
            
            day, prevStock, turn, stocks
            
            turn == 'B'
                pos1 = stock[day] - fun(day + 1, 'S', stock)
                pos2 = fun(day + 1, 'B', tock)
                
                return max(pos1, pos2);
            else
                pos1 = stock[day] + fun(day + 1, 'B', stock)
                pos2 = fun(day + 1, 'S', stock)
                
                return max(pos1, pos2)
        
        */
        
        int n = prices.length;
        
        memo = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return maximumProfitUtil(0, 0, prices);
    }
}