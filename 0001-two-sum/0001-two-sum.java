class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            mp.put(nums[i], i);
        }
        
        for(int i = 0; i < n; i++) {
            int targetNum = -1;
            
            if((nums[i] + target - nums[i]) == target) {
                targetNum = target - nums[i];
            } else {
                targetNum = target + nums[i];
            }
            
            if(mp.containsKey(targetNum) && 
               mp.get(targetNum) != i) {
                return new int[] {i, mp.get(targetNum)};
            }
        }
        
        return new int[] {-1, -1};
    }
}