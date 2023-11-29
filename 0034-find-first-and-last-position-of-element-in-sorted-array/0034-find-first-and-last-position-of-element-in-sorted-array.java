class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        
        if(n == 0){
            return new int[]{-1, -1};
        }
        
        int firstIndex = findStartIndex(nums, target, n);
        int lastIndex = findLastIndex(nums, target, n);
        
        return new int[]{firstIndex, lastIndex};
    }
    
    private int findStartIndex(int nums[], int target, int n){
        int left = 0, right = n - 1;
        int index = -1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }
    
    private int findLastIndex(int nums[], int target, int n){
        int left = 0, right = n - 1;
        int index = -1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                index = mid;
                left = mid + 1;
            }
        }
        return index;
    }
}