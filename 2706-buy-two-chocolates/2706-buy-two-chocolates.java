class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int chocolate1 = prices[0];
        int chocolate2 = prices.length > 1 ? prices[1] : 0;
        return money >= (chocolate1 + chocolate2) ? 
                 (money - (chocolate1 + chocolate2)) : 
                   money;
    }
}