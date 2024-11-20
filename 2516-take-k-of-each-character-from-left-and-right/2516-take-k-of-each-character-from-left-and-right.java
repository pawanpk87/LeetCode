class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        
        int[] count = new int[3];
        
        for(char ch : s.toCharArray()) {
            count[(ch - 'a')]++;
        }
        
        for(int i = 0; i < 3; i++) {
            if(count[i] < k) {
                return -1;
            }
        }
        
        int maxWindow = 0;
        
        int[] windowCount = new int[3];
        int i = 0, j = 0;
        
        while(j < n) {
            windowCount[(s.charAt(j) - 'a')]++;
            
            while(i <= j && (
                (count[0] - windowCount[0]) < k ||
                (count[1] - windowCount[1]) < k ||
                (count[2] - windowCount[2]) < k
            )) {
                windowCount[(s.charAt(i) - 'a')]--;
                i++;
            }
            
            maxWindow = Math.max(maxWindow, j - i + 1);
            
            j++;
        }
        
        return (n - maxWindow);
    }
}