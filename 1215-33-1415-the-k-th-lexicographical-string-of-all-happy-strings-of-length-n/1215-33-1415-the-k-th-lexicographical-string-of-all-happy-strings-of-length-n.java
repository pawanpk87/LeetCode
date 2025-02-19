class Solution {
    private void generateHappyStr(StringBuilder currHappyStr, int n, char[] happyChars, List<String> happyStrs) {
        if(currHappyStr.length() == n) {
            happyStrs.add(currHappyStr.toString());
            return;
        }
        
        char prevChar = currHappyStr.length() == 0 ? '$' : currHappyStr.charAt(currHappyStr.length() - 1);
        
        for(char ch : happyChars) {
            if(ch == prevChar){
                continue;
            }

            currHappyStr.append(ch);
            generateHappyStr(currHappyStr, n, happyChars, happyStrs);
            currHappyStr.deleteCharAt(currHappyStr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        List<String> happyStrs = new ArrayList<>();

        char[] happyChars = new char[] {'a', 'b', 'c'};
        StringBuilder currHappyStr = new StringBuilder();

        generateHappyStr(currHappyStr, n, happyChars, happyStrs);

        return happyStrs.size() <= (k - 1) ? "" : happyStrs.get(k - 1);
    }
}