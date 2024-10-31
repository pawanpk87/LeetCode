class Solution {
    private int currIndex;
    
    private boolean evaluate(String expression) {
        Stack<Boolean> st = new Stack<>();
        
        char operationType = expression.charAt(currIndex);
        
        currIndex = currIndex + 2;
        
        while(currIndex < expression.length()) {
            if(expression.charAt(currIndex) == ',') {
                currIndex++;
                continue;
            }
            
            if(expression.charAt(currIndex) == 't' || expression.charAt(currIndex) == 'f') {
                st.push(expression.charAt(currIndex) == 't' ? true : false);
                currIndex++;
            } else if(expression.charAt(currIndex) == '&' ||
                        expression.charAt(currIndex) == '|' ||
                          expression.charAt(currIndex) == '!') {
                st.push(evaluate(expression));
            } else {
                currIndex++;
                break;
            }
        }
        
        boolean result = st.pop();
        
        if(operationType == '!') {
            return !result;  
        }
        
        while(!st.isEmpty()) {
            result = operation(result, st.pop(), operationType);
        }
        
        return result;
    }
    
    private boolean operation(boolean a, boolean b, char operationType) {
        if(operationType == '|') {
            return a | b;
        } else {
            return a & b;
        }
    }
    
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        
        currIndex = 0;
        
        return evaluate(expression);
    }
}