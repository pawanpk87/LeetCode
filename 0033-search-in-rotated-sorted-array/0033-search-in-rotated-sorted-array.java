class Solution {
    private int findPivotIndex(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = (left + right) / 2;
            
            int leftIndex = (n + mid - 1) % n;
            int rightIndex = (mid + 1) % n;
            
            if(nums[leftIndex] >= nums[mid] && nums[mid] <= nums[rightIndex]){
                return mid;
            }
            
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return -1;
    }
    
    private int binarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        
        int mid = (left + right) / 2;
        
        if(nums[mid] == target){
            return mid;
        }
        
        if(nums[mid] < target){
            return binarySearch(nums, mid + 1, right, target);
        } else{
            return binarySearch(nums, left, right - 1, target);
        }
    }
    
    public int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums, target);
        int index = binarySearch(nums, 0, pivotIndex -1, target);
        if(index == -1){
            index = binarySearch(nums, pivotIndex, nums.length - 1, target);
        }
        return index;
    }
}