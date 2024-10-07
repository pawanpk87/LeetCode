class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(!st.isEmpty()) {
                if((st.peek() == 'A' && ch == 'B') || 
                   (st.peek() == 'C' && ch == 'D')) {
                    st.pop();
                    continue;
                }
            }
            st.push(ch);
        }
        
        return st.size();
    }
}