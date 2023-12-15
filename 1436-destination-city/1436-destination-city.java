class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> degree = new HashMap<>();
        
        for(List<String> path : paths){
            String cityA = path.get(0);
            String cityB = path.get(1);
            degree.put(cityA, degree.getOrDefault(cityA, 0) + 1);
            degree.put(cityB, degree.getOrDefault(cityB, 0));
        }
        
        for(Map.Entry<String, Integer> data : degree.entrySet()){
            if(data.getValue() == 0){
                return data.getKey();
            }
        }
        
        return "";
    }
}