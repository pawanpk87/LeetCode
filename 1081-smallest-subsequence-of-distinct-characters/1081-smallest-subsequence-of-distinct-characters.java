class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        
        boolean isPresent[] = new boolean[26];
        int lastIndex[] = new int[26];

        IntStream.range(0, n)
                    .forEach(i-> lastIndex[s.charAt(i) - 'a'] = i);
        
        Stack<Character> st = new Stack<>();

        IntStream.range(0, n)
                    .forEach(i->{
                        char ch = s.charAt(i);
                        if(isPresent[ch - 'a'] == false){
                            while(st.size() > 0 &&
                                  st.peek() > ch &&
                                  lastIndex[st.peek() - 'a'] > i){
                                isPresent[st.pop() - 'a'] = false;
                            }
                            isPresent[ch - 'a'] = true;
                            st.push(ch);
                        }
                    });

        StringBuilder sb = new StringBuilder();

        while(!st.empty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}