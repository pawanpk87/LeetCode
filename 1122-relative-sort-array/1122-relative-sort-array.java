class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        ArrayList<Integer> remaining = new ArrayList<>();
        
        for(int num : arr2){
            countMap.put(num, 0);
        }
        
        for(int num : arr1){
            if(countMap.containsKey(num)){
                countMap.put(num, countMap.get(num) + 1);
            } else{
                remaining.add(num);
            }
        }
        
        Collections.sort(remaining);
        
        int[] result = new int[arr1.length];
        int index = 0;
        for(int num : arr2){
            for(int j = 0; j < countMap.get(num); j++){
                result[index++] = num;
            }
        }
        
        for(int num : remaining){
            result[index++] = num;
        }
        
        return result;
    }
}