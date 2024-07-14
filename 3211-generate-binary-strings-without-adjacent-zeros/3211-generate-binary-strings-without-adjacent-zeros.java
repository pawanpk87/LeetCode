class Solution {
    public List<String> validStrs;
    
    public List<String> validStrings(int n) {
        validStrs = new ArrayList<String>();
        StringBuilder currStr = new StringBuilder();
        generateBalidBinaryStr(currStr, n);
        return validStrs;
    }
    
    private void generateBalidBinaryStr(StringBuilder currStr, int n){
        if(n == 0){
            validStrs.add(currStr.toString());
            return;
        }
        if(currStr.length() == 0 || currStr.charAt(currStr.length() - 1) == '1'){
            currStr.append('1');
            generateBalidBinaryStr(currStr, n-1);
            
            currStr.deleteCharAt(currStr.length() - 1);
            
            currStr.append('0');
            generateBalidBinaryStr(currStr, n-1);
            
            currStr.deleteCharAt(currStr.length() - 1);
        } else {
            currStr.append('1');
            generateBalidBinaryStr(currStr, n-1);
            
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
}