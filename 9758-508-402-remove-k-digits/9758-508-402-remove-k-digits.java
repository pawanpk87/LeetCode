class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(char ch : num.toCharArray()) {
            while(!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k--;
            }

            if(st.size() > 0 || ch != '0') {
                st.push(ch);
            }
        }

        while(k-- > 0 && st.size() > 0) {
            st.pop();
        }

        StringBuilder resNum = new StringBuilder();

        while(!st.isEmpty()) {
            resNum.append(st.pop());
        }

        return resNum.length() == 0 ? "0" : resNum.reverse().toString();
    }
}