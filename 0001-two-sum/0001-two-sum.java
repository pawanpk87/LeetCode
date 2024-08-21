class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            mp.put(nums[i], i);
        }
        
        for(int i = 0; i < n; i++) {
            int rem = target - nums[i];
            if(mp.containsKey(rem) && 
               mp.get(rem) != i) {
                return new int[] {i, mp.get(rem)};
            }
        }
        
        return null;
    }
}