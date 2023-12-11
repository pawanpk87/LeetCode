class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int reqFreq = ((25*n)/100);
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> data : freq.entrySet()){
            if(data.getValue() > reqFreq){
                return data.getKey();
            }
        }
        return -1;
    }
}