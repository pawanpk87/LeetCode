class Solution {
    private int[] memo;

    private int mincostTicketsUtil(int index, int[] days, int[] costs) {
        if(index >= days.length) {
            return 0;
        }

        if(memo[index] != -1) {
            return memo[index];
        }

        int minCost = Integer.MAX_VALUE;

        minCost = costs[0] + mincostTicketsUtil(getNearestDay(index, days[index] + 1, days), days, costs);

        minCost = Math.min(
            minCost, 
            costs[1] + mincostTicketsUtil(getNearestDay(index, days[index] + 7, days), days, costs)
        );

        minCost = Math.min(
            minCost, 
            costs[2] + mincostTicketsUtil(getNearestDay(index, days[index] + 30, days), days, costs)
        );

        return memo[index] = minCost;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return mincostTicketsUtil(0, days, costs);
    }

    private int getNearestDay(int currIndex, int maxDay, int[] days) {
        int n = days.length;

        while(currIndex < n && days[currIndex] < maxDay) {
            currIndex++;
        }

        return currIndex;
    }
}