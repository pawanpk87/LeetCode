class Solution {
    private boolean isPossible(int[] start, int d, int minDiff) {
        int prevChosenNum = start[0];
        
        for(int i = 1; i < start.length; i++) {
            int nextChosenNum = Math.max(prevChosenNum + minDiff, start[i]);
            
            if(nextChosenNum > (start[i] + d)) {
                return false;
            }
            
            prevChosenNum = nextChosenNum;
        }
        
        return true;
    }
    
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        
        int low = 0, high = Integer.MAX_VALUE;
        
        int res = -1;
    
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(isPossible(start, d, mid)) {
                res = Math.max(res, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return res;
    }
}