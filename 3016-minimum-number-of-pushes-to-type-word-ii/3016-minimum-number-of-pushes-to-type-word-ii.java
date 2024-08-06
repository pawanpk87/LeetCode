class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        
        for(int i = 0; i < word.length(); i++) {
            count[(word.charAt(i) - 'a')]++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < 26; i++) {
            maxHeap.add(count[i]);
        }
        
        int pushes = 0;
        int currPush = 1;
        while(!maxHeap.isEmpty()) {
            for(int k = 1; k <= 8 && !maxHeap.isEmpty(); k++) {
                pushes += currPush * maxHeap.poll();
            }
            currPush++;
        }
        
        return pushes;
    }
}