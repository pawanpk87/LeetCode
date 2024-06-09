class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int currSum = 0;
        for(int num : nums){
            currSum += num;
            int rem = (currSum%k + k)%k;
            if(mp.containsKey(rem)){
                count += mp.get(rem);
            }
            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}