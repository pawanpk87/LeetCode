class Solution {
    private boolean isValid(int n, int[] quantities, int k) {
        int m = quantities.length;
        
        int j = 0;
        int remaining = quantities[0];
        
        for(int i = 0; i < n; i++) {
            if(remaining <= k) {
                j++;
                if(j == m) {
                    return true;
                } else {
                    remaining = quantities[j];
                }
            } else {
                remaining -= k;
            }
        }
        
        return false;
    }
    
    public int minimizedMaximum(int n, int[] quantities) {
        
        int maxQ = 0;
        
        for(int q : quantities) {
            maxQ = Math.max(maxQ, q);
        }
        
        int minX = Integer.MAX_VALUE;
        int low = 1, high = maxQ;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            if(isValid(n, quantities, mid)) {
                minX = Math.min(minX, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return minX;
    }
}