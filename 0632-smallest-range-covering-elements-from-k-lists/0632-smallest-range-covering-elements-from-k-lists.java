class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        
        int[] indices = new int[k];
        
        int[] range = new int[] {0, Integer.MAX_VALUE};
        
        while(true) {
            int minNum = Integer.MAX_VALUE;
            int maxNum = Integer.MIN_VALUE;
            int minNumIndex = 0;
    
            for(int i = 0; i < k; i++) {
                int currNum = nums.get(i).get(indices[i]);
                
                if(minNum > currNum) {
                    minNum = currNum;
                    minNumIndex = i;
                }
                
                if(maxNum < currNum) {
                    maxNum = currNum;
                }
            }
            
            if((maxNum - minNum) < (range[1] - range[0])) {
                range[0] = minNum;
                range[1] = maxNum;
            }
            
            if(++indices[minNumIndex] == nums.get(minNumIndex).size()) {
                break;
            }
        }
        
        return range;
    }
}