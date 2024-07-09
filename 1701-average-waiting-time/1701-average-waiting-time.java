class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        
        int prevIdleTime = 1;
        double totalWaitTime = 0;
        
        int arrival, time;
        int endTime;
        
        for(int[] customer : customers){
            arrival = customer[0];
            time = customer[1];
            
            if(arrival <= prevIdleTime) {
                endTime = prevIdleTime + time;
            } else {
                endTime = arrival + time;
            }
            
            totalWaitTime += (endTime - arrival);
            
            prevIdleTime = endTime;
        }
        
        return totalWaitTime/n;
    }
}