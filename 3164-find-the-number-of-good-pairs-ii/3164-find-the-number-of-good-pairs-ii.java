class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums2){
            int currNum = num * k;
            freq.put(currNum, freq.getOrDefault(currNum, 0) + 1);
        }
        
        long count = 0;
        for(int num : nums1){
            int sr = (int) Math.sqrt(num);
            for(int i = 1; i <= sr; i++){
                if(num%i != 0){
                    continue;
                }
                count += freq.getOrDefault(i, 0);
                if(i != (num/i)){
                    count += freq.getOrDefault(num/i, 0);
                }
            }
        }
        
        return count;
    }
}