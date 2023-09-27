class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        
        long totalLength = 0;

        for(int i = 0; i < n; i++){
            if(Character.isDigit(s.charAt(i))){
                totalLength *= (s.charAt(i) - '0');
            }else{
                totalLength++;
            }
        }

        for(int i = n-1; i >= 0; i--){
            k %= totalLength;

            if(k == 0 && Character.isAlphabetic(s.charAt(i))){
                return ""+s.charAt(i);
            }

            if(Character.isAlphabetic(s.charAt(i))){
                totalLength--;
            }else{
                totalLength /= (s.charAt(i) - '0');
            }
        }

        return "";
    }
}