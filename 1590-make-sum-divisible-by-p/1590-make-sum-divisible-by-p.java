class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        
        int sum = 0;
        for(int num : nums) {
            sum = (sum + num) % p;
        }
        
        int rem = sum % p;
        
        if(rem == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        mp.put(0, -1);
        
        int minLen = n;
        int currSum = 0;
        
        for(int i = 0; i < n; i++) {
            currSum = (currSum + nums[i]) % p;
            
            int targetNum = (currSum - rem + p) % p;
            
            if(mp.containsKey(targetNum)) {
                minLen = Math.min(minLen, i - mp.get(targetNum));
            }
            
            mp.put(currSum, i);
        }
        
        return minLen == n ? -1 : minLen;
    }
}