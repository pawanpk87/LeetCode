class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        int start0 = 0;
        int start1 = 0;
        
        for(int i = 0; i < n; i++){
            if(i%2 == 0){
                if(s.charAt(i) == '0'){
                    start1++;
                }else{
                    start0++;
                }
            }else{
                if(s.charAt(i) == '1'){
                    start1++;
                }else{
                    start0++;
                }
            }
        }
        
        return Math.min(start0, start1);
    }
}
/*
   "10010100"
    ||     |
    01010101
    
    |
    
    start1
    start0
    
    
    
    "1111"
     0101
     1010
     
    
*/