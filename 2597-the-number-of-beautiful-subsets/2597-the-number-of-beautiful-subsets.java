class Solution {
    private Map<Integer, Integer> freq;
    
    private int solve(int currIndex, int[] nums, int k){
        if(currIndex == nums.length){
            return 1;
        }
        int pos1 = 0, pos2 = 0;
        
        pos1 = solve(currIndex + 1, nums, k);
        
        if(!freq.containsKey(nums[currIndex] - k) 
           && !freq.containsKey(nums[currIndex] + k)){
            freq.put(nums[currIndex], freq.getOrDefault(nums[currIndex], 0) + 1);
            
            pos2 = solve(currIndex + 1, nums, k);
            
            freq.put(nums[currIndex], freq.get(nums[currIndex]) - 1);
            
            if(freq.get(nums[currIndex]) == 0){
                freq.remove(nums[currIndex]);
            }
        }
        
        return pos1 + pos2;
    }
    
    public int beautifulSubsets(int[] nums, int k) {
        freq = new HashMap<>();
        return solve(0, nums, k) - 1;
    }
}