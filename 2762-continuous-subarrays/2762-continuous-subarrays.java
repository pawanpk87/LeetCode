class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        
        long count = 0;
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        
        int i = 0, j = 0;
        
        while(j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            
            while((mp.lastEntry().getKey() - mp.firstEntry().getKey()) > 2) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if(mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }
            
            count += (j - i + 1);
            
            j++;
        }
        
        return count;
    }
}