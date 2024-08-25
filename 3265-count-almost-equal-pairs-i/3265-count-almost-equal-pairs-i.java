class Solution {
    private boolean isAlmostEqual(String numStr1, String numStr2) {
        StringBuilder sb1 = new StringBuilder(numStr1);
        StringBuilder sb2 = new StringBuilder(numStr2);
        
        sb1.reverse();
        sb2.reverse();
        
        int n = sb1.length();
        int m = sb2.length();
        
        int max = Math.max(n, m);
        
        while(n != max) {
            sb1.append('0');
            n++;
        }
        
        while(m != max) {
            sb2.append('0');
            m++;
        }
        
        sb1.reverse();
        sb2.reverse();
        
        int diffCount = 0;
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();
        
        for(int i = 0; i < max; i++) {
            if(sb1.charAt(i) != sb2.charAt(i)) {
                diffCount++;
            }
            mp1.put(sb1.charAt(i), mp1.getOrDefault(sb1.charAt(i), 0) + 1);
            mp2.put(sb2.charAt(i), mp2.getOrDefault(sb2.charAt(i), 0) + 1);
        }
        
        if(diffCount > 2) {
            return false;
        }
        
        for(Map.Entry<Character, Integer> data : mp1.entrySet()) {
            if(data.getValue() != mp2.get(data.getKey())) {
                return false;
            }
        }
        
        return true;
    }
    
    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isAlmostEqual(String.valueOf(nums[i]), String.valueOf(nums[j]))) {
                    count++;
                }
            }
        }
        return count;
    }
}