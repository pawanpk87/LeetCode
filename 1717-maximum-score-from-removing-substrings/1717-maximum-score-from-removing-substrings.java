class Solution {
    public int maximumGain(String s, int x, int y) {
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = "ab".equals(highPriorityPair) ? "ba" : "ab";
        
        String stringAfterFirstPass = removeString(s, highPriorityPair);
        int maxScore = ((s.length() - stringAfterFirstPass.length())/2) * Math.max(x, y);
        
        String stringAfterSecond = removeString(stringAfterFirstPass, lowPriorityPair);
        maxScore += ((stringAfterFirstPass.length() - stringAfterSecond.length())/2) * Math.min(x, y);
        
        return maxScore;
    }
    
    private String removeString(String s, String targetPair){
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == targetPair.charAt(1) &&
               !st.isEmpty() &&
               st.peek() == targetPair.charAt(0)){
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}