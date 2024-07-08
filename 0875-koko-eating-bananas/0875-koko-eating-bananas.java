class Solution {
    private boolean isValid(int[] piles, int k, int h){
        long count = 0;
        for(int pile : piles){
            if(pile <= k){
                count++;
            } else {
                count += pile/k;
                if(pile%k > 0){
                    count++;
                }
            }
        }
        return count <= h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low =  1;
        int high = Integer.MIN_VALUE;
        for(int pile : piles){
            high = Math.max(high, pile);
        }
        
        int minK = Integer.MAX_VALUE;
        
        while(low <= high){
            int mid = (low + high)/2;
            if(isValid(piles, mid, h)){
                minK = Math.min(minK, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return minK;
    }
}