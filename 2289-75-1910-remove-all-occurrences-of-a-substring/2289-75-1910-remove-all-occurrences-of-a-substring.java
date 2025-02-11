class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            st.push(ch);
            
            if(st.size() >= m && isSubstringPresent(st, part)) {
                for(int i = 0; i < m; i++) {
                    st.pop();
                }
            }
        }

        StringBuilder resStr = new StringBuilder();

        while(!st.isEmpty()) {
            resStr.append(st.pop());
        }

        return resStr.reverse().toString();
    }

    private boolean isSubstringPresent(Stack<Character> st, String part) {
        int n = part.length();

        Stack<Character> tempSt = new Stack<>();
        tempSt.addAll(st);

        for(int i = n - 1; i >= 0; i--) {
            if(tempSt.isEmpty() || tempSt.peek() != part.charAt(i)) {
                return false;
            }

            tempSt.pop();
        }

        return true;
    }
}