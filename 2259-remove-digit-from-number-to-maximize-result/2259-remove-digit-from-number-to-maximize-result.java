class Solution {
    public String removeDigit(String number, char digit) {
        int deleteCharIndex = findFirstOccurence(number, digit);
        return number.substring(0, deleteCharIndex) + number.substring(deleteCharIndex+1);
    }
    
    private int findFirstOccurence(String number, char digit){
        int n = number.length();
        int lastCharIndex = -1;
        for(int i = 0; i < (n-1); i++){
            if(number.charAt(i) == digit){
                if(number.charAt(i) < number.charAt(i+1)){
                    return i;
                }
                lastCharIndex = i;
            }
        }
        return number.charAt(n-1) == digit ? n-1 : lastCharIndex;
    }
}