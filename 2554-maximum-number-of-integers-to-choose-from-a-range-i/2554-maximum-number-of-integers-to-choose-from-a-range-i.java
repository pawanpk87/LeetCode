class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> st = new HashSet<>();
        
        for(int num : banned) {
            st.add(num);
        }
        
        int count = 0;
        
        for(int num = 1; num <= n; num++) {
            if(st.contains(num)) {
                continue;
            }
            
            if(maxSum - num < 0) {
                return count;
            }
            
            maxSum -= num;
            count++;
        }
        
        return count;
    }
}