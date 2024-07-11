class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        
        Stack<Integer> openParenthesesIndices = new Stack<>();
        int[] pair = new int[n];
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '(') {
                openParenthesesIndices.push(i);
            } else if(ch == ')') {
                int j = openParenthesesIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        
        StringBuilder resStr = new StringBuilder();
        
        for(int currIndex = 0, direction = 1; currIndex < n; currIndex += direction){
            char ch = s.charAt(currIndex);
            if(ch == '(' || ch == ')'){
                currIndex = pair[currIndex];
                direction = -1 * direction;
            } else {
                resStr.append(ch);
            }
        }
        
        return resStr.toString();
    }
}