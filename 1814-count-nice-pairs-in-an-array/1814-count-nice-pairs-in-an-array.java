class Solution {
    public static int MOD = 1000000007;
    
    private int rev(int num) {
        int revNum = 0;
        while(num > 0) {
            revNum = revNum * 10 + num % 10;
            num = num / 10;
        }
        return revNum;
    }
    
    public int countNicePairs(int[] nums) {
        int count = 0;
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int num : nums) {
            int targetNum = num - rev(num);
            
            if(mp.containsKey(targetNum)) {
                count = (count + mp.get(targetNum)) % MOD;
            }
            
            mp.put(targetNum, mp.getOrDefault(targetNum, 0) + 1);
        }
        
        return count;
    }
}
/*
        
        nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        
        nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])


        42 + rev(97) = 97 + rev(42)
        121 = 121
        
        
        [42, 11, 1, 97]
                    |
         18  0   0  18
        
        97
        
     79
     18
     97
          
        
*/