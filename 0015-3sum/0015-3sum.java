class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < n - 2; i++) {
            int target = -nums[i];
            
            int left = i + 1;
            int right = n - 1;
            
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum < target) {
                    left++;
                } else if(sum > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    int leftNum = nums[left];
                    int rightNum = nums[right];
                    
                    while(left < right && nums[left] == leftNum) {
                        left++;
                    }
                    
                    while(right > left && nums[right] == rightNum) {
                        right--;
                    }
                }
            }
            
            while((i + 1) < n && nums[i] == nums[i+1]) {
                i++;
            }
        }
        
        return res;
    }
}