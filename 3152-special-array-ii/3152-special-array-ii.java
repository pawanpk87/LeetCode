class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        
        ArrayList<Integer> index = new ArrayList<>();
        
        for(int i = 1; i < n; i++) {
            if(nums[i - 1]%2 == nums[i]%2) {
                index.add(i);
            }
        }
        
        boolean[] res = new boolean[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            res[i] = binarySearch(index, queries[i][0] + 1, queries[i][1]);
        }
        
        return res;
    }
    
    private boolean binarySearch(ArrayList<Integer> index, int start, int end) {
        int low = 0, high = index.size() - 1;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            int voilatingIndex = index.get(mid);
            
            if(voilatingIndex < start) {
                low = mid + 1;
            } else if(voilatingIndex > end) {
                high = mid - 1;
            } else {
                return false;
            }
        }
        
        return true;
    }
}