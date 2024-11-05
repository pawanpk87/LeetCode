class Solution {
    public int minChanges(String s) {
        int n = s.length();
        
        int count = 0;
        
        for(int i = 1; i < n; i += 2) {
            if(s.charAt(i - 1) != s.charAt(i)) {
                count++;
            }    
        }
        
        return count;
    }
}

/*

    Approach 1:
                1001
        
        
        
        if len is odd and 
             
            opt1 = make changes
                    len
                    ones = 0
                    zeros = 0
            opt2 = 
                    len
                    ones = ones
                    zeros = zeros
                    
        else 
            opt2 = 
                    len
                    ones = ones
                    zeros = zeros
    
    
    Approach 2:
    
            divide the string into clustur of 2 size
            
*/