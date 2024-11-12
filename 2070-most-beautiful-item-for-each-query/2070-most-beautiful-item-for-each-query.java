class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // sort based on price
        Arrays.sort(items, new Comparator<int[]>(){
           public int compare(int[] item1, int[] item2) {
               if(item1[0] == item2[0]) {
                   return item1[1] - item2[1]; 
               }
               return item1[0] - item2[0];
           } 
        });
        
        int n = items.length;
        
        // pre compute max num
        int[] maxNum = new int[n];
        
        maxNum[0] = items[0][1];
        for(int i = 1; i < n; i++) {
            maxNum[i] = Math.max(maxNum[i - 1], items[i][1]);
        }
        
        int[] ans = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            // find the max index of the item whoes price <= queries[i]
            int targetIndex = binarySearch(items, queries[i]);
            
            if(targetIndex != -1) {
                ans[i] = maxNum[targetIndex];
            } else {
                ans[i] = 0;
            }
        }
        
        return ans;
    }
    
    private int binarySearch(int[][] items, int targetPrice) {
        int n = items.length;
        
        int maxIndex = -1;
        
        int low = 0, high = n - 1;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            if(items[mid][0] <= targetPrice) {
                maxIndex = Math.max(maxIndex, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return maxIndex;
    }
}