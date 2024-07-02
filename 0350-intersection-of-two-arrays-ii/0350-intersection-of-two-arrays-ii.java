class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums1){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int num : nums2){
            int f = freq.getOrDefault(num, 0);
            if(f > 0){
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}