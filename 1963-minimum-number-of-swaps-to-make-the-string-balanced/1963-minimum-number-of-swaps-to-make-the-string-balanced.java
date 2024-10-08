class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int mismatch = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '[') {
                st.push(ch);
            } else {
                if(!st.isEmpty()) {
                    st.pop();
                } else {
                    mismatch++;
                }
            }
        }
        return (mismatch + 1)/2;
    }
}