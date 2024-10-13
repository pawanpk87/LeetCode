class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> numOfPassengers = new TreeMap<>();
        
        int startPos, endPos, numOfPass;
        for(int[] trip : trips) {
            numOfPass = trip[0];
            startPos = trip[1];
            endPos = trip[2];
            
            numOfPassengers.put(startPos, numOfPassengers.getOrDefault(startPos, 0) + numOfPass);
            numOfPassengers.put(endPos, numOfPassengers.getOrDefault(endPos, 0) - numOfPass);
        }
        
        int currNumOfPassengers = 0;
        
        for(int passengers : numOfPassengers.values()) {
            currNumOfPassengers += passengers;
            if(currNumOfPassengers > capacity) {
                return false;
            }
        }
        
        return true;
    }
}