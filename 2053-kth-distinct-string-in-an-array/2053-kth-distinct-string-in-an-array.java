class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freq = new HashMap<>();
        
        for(String str : arr) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(freq.get(arr[i]) == 1) {
                if(k == 1) {
                    return arr[i];
                }
                k--;
            }
        }
        
        return "";
    }
}