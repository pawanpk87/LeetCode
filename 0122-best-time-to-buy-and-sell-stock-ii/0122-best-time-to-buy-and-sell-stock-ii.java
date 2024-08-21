class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length - 1;
        
        int profit = 0;
        
        int index = 0;
        
        while(index < n) {
            int buy = 0;
            int sell = 0;
            
            while(index < n && prices[index + 1] <= prices[index]) {
                index++;
            }
            buy = prices[index];
            
            while(index < n && prices[index + 1] > prices[index]) {
                index++;
            }
            sell = prices[index];
            
            profit += sell - buy;
        }
        
        return profit;
    }
}