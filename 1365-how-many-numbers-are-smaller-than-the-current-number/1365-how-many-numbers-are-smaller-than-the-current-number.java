class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        
        int[] sortedArray = Arrays.copyOf(nums, n);
        Arrays.sort(sortedArray);
        
        int[] resArr = new int[nums.length];
        for(int i = 0; i < n; i++){
            resArr[i] = lowerBound(sortedArray, nums[i]);
        }
        
        return resArr;
    }
    
    private int lowerBound(int[] nums, int targetNum){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < targetNum){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }
}