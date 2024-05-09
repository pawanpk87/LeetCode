class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        for(int happy : happiness){
            maxHeap.add(happy);
        }
        
        int decHappiness = 0;
        long totalHappiness = 0;
        while(k-- > 0){
            int currChildHappiness = maxHeap.poll() - decHappiness;
            totalHappiness += (currChildHappiness > 0 ? currChildHappiness : 0);
            decHappiness++;
        }
        
        return totalHappiness;
    }
}