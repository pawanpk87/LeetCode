class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        
        for(int num : nums) {
            int targetNum = num - k;
            if(mp.containsKey(targetNum)) {
                count += mp.get(targetNum);
            }
        }
        
        return count;
    }
}