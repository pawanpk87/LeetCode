class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int maxStrNum = -1;
        String resStr = "";
        for(int i = 0; i <= (n - 3); i++){
            char ch1 = num.charAt(i);
            char ch2 = num.charAt(i+1);
            char ch3 = num.charAt(i+2);
            if(ch1 == ch2 && ch2 == ch3){
                int currStrNum = Integer.parseInt(num.substring(i, i+3));
                if(currStrNum > maxStrNum){
                    maxStrNum = currStrNum;
                    resStr = num.substring(i, i+3);
                }
            }
        }
        return resStr;
    }
}