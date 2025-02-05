class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        
        int firstIndex = 0, secondIndex = 0;
        int diffChars = 0;
        
        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diffChars++;
                
                if(diffChars > 2) {
                    return false;
                } else if(diffChars == 1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                }
            }
        }
        
        return (
            s1.charAt(firstIndex) == s2.charAt(secondIndex) &&
            s1.charAt(secondIndex) == s2.charAt(firstIndex)
        );
    }
}