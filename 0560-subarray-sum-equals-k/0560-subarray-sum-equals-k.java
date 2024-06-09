class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(mp.containsKey(sum - k)){
                count += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}