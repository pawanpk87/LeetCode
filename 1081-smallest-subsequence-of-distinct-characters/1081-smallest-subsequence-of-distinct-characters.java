class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        
        int[] lastIndex = new int[26];
        boolean[] isPresent = new boolean[26];
        
        IntStream.range(0, n)
            .forEach(i -> lastIndex[s.charAt(i) - 'a'] = i);
        
        Stack<Character> st = new Stack<>();
        
        IntStream.range(0, n)
            .forEach(i-> {
                char ch = s.charAt(i);
                if(isPresent[ch - 'a'] == false){
                   while(!st.isEmpty() &&
                           st.peek() > ch &&
                            lastIndex[st.peek() - 'a'] > i){
                        isPresent[st.pop() - 'a'] = false;
                    } 
                    st.push(ch);
                    isPresent[ch - 'a'] = true;
                }
            });
        
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}