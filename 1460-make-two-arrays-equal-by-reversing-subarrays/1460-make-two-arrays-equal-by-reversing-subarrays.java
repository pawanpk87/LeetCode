class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : target) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for(int num : arr) {
            if(freq.containsKey(num) == false) {
                return false;
            }
            
            int prevFreq = freq.get(num);
            prevFreq--;
            
            if(prevFreq < 0) {
                return false;
            }
            
            freq.put(num, prevFreq);
        }
        
        for(Integer c : freq.values()) {
            if(c != 0){
                return false;
            }
        }
        
        return true;
    }
}