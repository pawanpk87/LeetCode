class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        
        int len = 0;
        int count = 1;
        
        for(int i = 1; i < n; i++){
            if(chars[i] != chars[i-1]){
                if(count > 1){
                    len = updateArr(chars, chars[i-1] + String.valueOf(count), len);
                } else{
                    len = updateArr(chars, chars[i-1] + "", len);
                }
                count = 1;
            } else {
                count++;
            }
        }
        
        if(count > 1){
            len = updateArr(chars, chars[n-1] + String.valueOf(count), len);
        } else{
            len = updateArr(chars, chars[n-1] + "", len);
        }
        
        return len;
    }
    
    private int updateArr(char[] chars, String str, int index){
        for(int i = 0; i < str.length(); i++){
            chars[index++] = str.charAt(i);
        }
        return index;
    }
}