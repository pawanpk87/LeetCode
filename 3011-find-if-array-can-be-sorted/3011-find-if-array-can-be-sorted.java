class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        
        int[] setBitCount = new int[n];
        for(int i = 0; i < n; i++) {
            setBitCount[i] = getSetBitCount(nums[i]);
        }
        
        int prevIndex = 0;
        int currBitCounts = setBitCount[0];
        
        for(int i = 1; i < n; i++) {
            if(setBitCount[i] != currBitCounts) {
                sortArr(nums, prevIndex, i);
                currBitCounts = setBitCount[i];
                prevIndex = i;
            }
        }
        
        sortArr(nums, prevIndex, n);
        
        return isSorted(nums);
    }
    
    private void sortArr(int[] nums, int startIndex, int endIndex) {
        Arrays.sort(nums, startIndex, endIndex);
    }
    
    private int getSetBitCount(int num) {
        int count = 0;
        
        for(int i = 0; i < 32; i++) {
            if((num & (1 << i)) != 0) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isSorted(int[] nums) {
        int n = nums.length;
        
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] > nums[i]) {
                return false;
            }
        }
        
        return true;
    }
}