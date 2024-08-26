class Solution {
    public static int MOD = 1000000007;
    
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            
            if(!st.isEmpty()) {
                leftBound[i] = st.peek() + 1;
            } else {
                leftBound[i] = 0;
            }
            
            st.push(i);
        }
        
        st.clear();
        
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            
            if(!st.isEmpty()) {
                rightBound[i] = st.peek() - 1;
            } else {
                rightBound[i] = n-1;
            }
            
            st.push(i);
        }
        
        long[] prefSum = new long[n + 1];
        for(int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + nums[i];
        }
        
        long res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, (prefSum[rightBound[i] + 1] - prefSum[leftBound[i]]) * nums[i]);
        }
        
        return ((int) (res % MOD));
    }
}