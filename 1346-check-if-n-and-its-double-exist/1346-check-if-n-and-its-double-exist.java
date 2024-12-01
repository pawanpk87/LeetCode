class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> index = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            index.put(arr[i], i);
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(index.containsKey(2 * arr[i]) && index.get(2 * arr[i]) != i) {
                return true;
            }
        }
        
        return false;
    }
}