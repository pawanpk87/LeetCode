class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Integer> sIndex = new HashMap<>();
        Map<Character, Integer> tIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            Integer prevIndexOfS = sIndex.put(s.charAt(i), i);
            Integer prevIndexOfT = tIndex.put(t.charAt(i), i);
            if(Objects.equals(prevIndexOfS, prevIndexOfT) == false){
                return false;
            }
        }
        return true;
    }
}