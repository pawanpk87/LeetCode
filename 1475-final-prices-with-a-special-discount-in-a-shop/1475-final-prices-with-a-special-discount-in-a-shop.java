class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        
        Stack<int[]> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek()[0] >= prices[i]) {
                prices[st.peek()[1]] = prices[st.peek()[1]] - prices[i];
                st.pop();
            }
            st.push(new int[]{prices[i], i});
        }
        
        return prices;
    }
}