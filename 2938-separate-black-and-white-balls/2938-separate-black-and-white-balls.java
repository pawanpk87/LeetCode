class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        
        int j = n - 1;
        while(j >= 0 && s.charAt(j) == '1') {
            j--;
        }
        
        if(j == 0) {
            return 0;
        }
        
        long totalOperations = 0;
        int i = j - 1;
        while(i >= 0) {
            if(s.charAt(i) == '1') {
                totalOperations += (j - i);
                j--;
            }
            i--;
        }
        
        return totalOperations;
    }
}