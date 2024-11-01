class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        
        if(n < 3) {
            return s;
        }
        
        StringBuilder facncyStr = new StringBuilder();
        
        facncyStr.append(s.charAt(0));
        facncyStr.append(s.charAt(1));
        
        for(int i = 2; i < n; i++) {
            int currLen = facncyStr.length();
            if(facncyStr.charAt(currLen - 2) == facncyStr.charAt(currLen - 1) &&
               facncyStr.charAt(currLen - 1) == s.charAt(i)) {
                continue;
            } else {
                facncyStr.append(s.charAt(i));
            }
        }
        
        return facncyStr.toString();
    }
}