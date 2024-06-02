class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            char ch = num.charAt(i);
            while(st.isEmpty() == false && st.peek() > ch && k > 0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(k-- > 0){
            st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.isEmpty() == false){
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != '0'){
                return sb.substring(i);
            }
        }
        
        return "0";
    }
}