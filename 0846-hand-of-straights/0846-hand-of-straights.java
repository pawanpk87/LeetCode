class Solution {
    private boolean isPossible(int nextExpectedNum, int currGroupSize, TreeMap<Integer, Integer> freq, int groupSize){
        if(freq.containsKey(nextExpectedNum) == false){
            return false;
        }
        
        if(freq.get(nextExpectedNum) == 1){
            freq.remove(nextExpectedNum);
        } else{
            freq.put(nextExpectedNum, freq.get(nextExpectedNum) - 1);
        }
        
        currGroupSize--;
        
        if(currGroupSize == 0){
            return freq.size() == 0 ? true : isPossible(freq.firstKey(), groupSize, freq, groupSize);
        } else{
            return isPossible(nextExpectedNum + 1, currGroupSize, freq, groupSize);
        }
    }
    
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int num : hand){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return isPossible(freq.firstKey(), groupSize, freq, groupSize);
    }
}