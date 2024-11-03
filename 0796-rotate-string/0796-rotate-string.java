class Solution {
    private boolean rotateStr(String s, String goal, int rotate) {
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != goal.charAt((i + rotate)%n)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        
        if(n != m) {
            return false;
        }
        
        for(int i = 1; i <= n; i++) {
            if(rotateStr(s, goal, i)) {
                return true;
            }
        }
        
        return false;
    }
}