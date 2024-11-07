class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitsCount = new int[32];
        
        for(int candidate : candidates) {
            for(int i = 0; i < 32; i++) {
                if(((1 << i) & candidate) != 0) {
                    bitsCount[i]++;
                }
            }
        }
        
        int largestCom = 0;
        
        for(int count : bitsCount) {
            largestCom = Math.max(largestCom, count);
        }
        
        return largestCom;
    }
}