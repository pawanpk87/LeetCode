class Solution {
    int[][][] digitDP;
    
    private int solve(int pos, int isLeading, int tight, int[] allowedDigits, int[] maxDigits) {
        if(pos == maxDigits.length) {
            return 1;
        }
        
        if(digitDP[pos][isLeading][tight] != -1) {
            return digitDP[pos][isLeading][tight];
        }
        
        int result = 0;
        
        int limit = tight == 1 ? maxDigits[pos] : 9;
        
        if(isLeading == 1) {
            result = solve(pos + 1, 1, 0, allowedDigits, maxDigits);    
        }
        
        for(int digit : allowedDigits) {
            if(digit <= limit) {
                int newTight = (tight == 1 && digit == limit) ? 1 : 0;
                
                result += solve(pos + 1, 0, newTight, allowedDigits, maxDigits); 
            }
        }
        
        return digitDP[pos][isLeading][tight] = result;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] allowedDigits = toIntArray(digits);
        int[] maxDigits = toIntArray(n);
        
        restDigitDP();
        
        return solve(0, 1, 1, allowedDigits, maxDigits) - 1;
    }
    
    public void restDigitDP() {
        digitDP = new int[11][2][2];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2; j++) {
                for(int l = 0; l < 2; l++) {
                    digitDP[i][j][l] = -1;
                }
            }
        }
    }
    
    private int[] toIntArray(String[] digits) {
        int[] result = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            result[i] = Integer.parseInt(digits[i]);
        }
        return result;
    }

    private int[] toIntArray(int n) {
        String numStr = String.valueOf(n);
        int[] result = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            result[i] = numStr.charAt(i) - '0';
        }
        return result;
    }
}
/*

    allowedDigits = ["1","3","5","7"], n = 100
    
    counts = ?
    

    target is to generate numbers of max digits length(n)
    
    
    n = 32532
    
    
    digits = [3, 2, 5, 3, 7]
              |   
            /   
          / 
 ["1","3","5","7"] -> options for the 0th place 
 
 
 
==========================================================================================
    
    F -> indicates that the previously choosen digit was the 
         smaller than the the digit
         
         ex:-
                         3
                         |
                 ["1","3","5","7"]

                   if we choose '1'
                        F = true
                   if we choose
                        F = false


==========================================================================================

Consider the input: digits = ["1", "3", "5"], n = 100
Without considering leading zeros, we would generate numbers like:
1, 3, 5, 11, 13, 15, 31, 33, 35, 51, 53, 55

   If isLeading is true, we have two choices:
        a. We can choose to place a digit from our set (1, 3, or 5 in this case)
        b. We can choose to keep it as a leading zero (which doesn't appear in the final number)

        If we choose to place a digit, isLeading becomes false for the rest of the number.
        If we choose to keep it as a leading zero, isLeading remains true for the next digit.



==========================================================================================
    
    fun ( 
        pos -> ith place of the digit
        
        isLeading -> true means can place zero, false means we can not place zeros
        
        F -> indicates that the previously choosen digit was the 
         smaller than the the digit
        
        allowedDigits
    )
    
    result = 0;
    
    
    // calculate limit
    
    limit = ?
    
    if F == true
        limit = '9'
    else
        limit = digit[pos]
        
        
    if isLeading is true
        result = result + fun (pos + 1, true, false)
    
    
    // iterate over all the options for the current ith place
    
    digit = 0;   digit <= limit 
        check if digit is present in "allowedDigits"
            
            newF = F
            
            if digit < limit
                newF = true
            else
                newF = false
            
            newCount
            
            since we are generate the all valid that means current is valid num
                newCont = count + 1;
            
            result = result + fun (
                pos + 1,
                newCount,
                F,
                allowedDigits
            )
        
    return result;
*/