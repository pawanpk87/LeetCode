class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(mp.containsKey(sum%k)){
                int len = i - mp.get(sum%k);
                if(len >= 2){
                    return true;
                }
            } else{
                mp.put(sum%k, i);
            }
        }
        return false;
    }
}