class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            if(columnNumber > 26){
                int rem = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
                columnNumber -= rem;
                columnNumber /= 26;
                rem--;
                
                sb.append((char)(rem + 'A'));
            }else{
                columnNumber--;
                sb.append((char)(columnNumber + 'A'));
                break;
            }
        }
        return sb.reverse().toString();
    }
}