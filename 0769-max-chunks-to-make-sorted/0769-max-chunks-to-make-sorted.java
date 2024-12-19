class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        
        prefixMax[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        
        suffixMin[n - 1] = arr[n - 1];
        for(int i = n-2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }
        
        int chunks = 0;
        
        for(int i = 0; i < n; i++) {
            if(i == 0 || suffixMin[i] > prefixMax[i - 1]) {
                chunks++;
            }
        }
        
        return chunks;
    }
}