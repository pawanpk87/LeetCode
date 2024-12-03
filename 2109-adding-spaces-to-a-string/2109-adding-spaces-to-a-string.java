class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        
        StringBuilder spaceAddedStr = new StringBuilder();
        
        int spaceIndex = 0;
        
        for(int i = 0; i < n; i++) {
            if(spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                spaceAddedStr.append(' ');
                spaceIndex++;
            }
            
            spaceAddedStr.append(s.charAt(i));
        }
        
        return spaceAddedStr.toString();
    }
}