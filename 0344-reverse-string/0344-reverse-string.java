class Solution {
    
    public void reverseStringUtil(char[] s,int left,int right){
        if(left < right)
        {
            // swap the character
            char tempChar = s[left];
            s[left] = s[right];
            s[right] = tempChar;
                
            reverseStringUtil(s,left+1,right-1);
        }
    }
    
    public void reverseString(char[] s) {
        reverseStringUtil(s,0,s.length-1);        
    }
    
}