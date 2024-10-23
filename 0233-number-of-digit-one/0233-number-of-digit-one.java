class Solution {
    int[][][] digitDp;
    
    private int solve(int pos, int count, int f, int[] digits) {
        if(pos == digits.length) {
            return count;
        }
        
        if(digitDp[pos][count][f] != -1) {
            return digitDp[pos][count][f];
        }
        
        int res = 0;
        
        int limit;
        
        if(f == 0) {
            limit = digits[pos];
        } else {
            limit = 9;
        }
        
        for(int digit = 0; digit <= limit; digit++) {
            int newF = f;
            int newCount = count;
            
            if(digit < limit) {
                newF = 1;    
            }
            
            if(digit == 1) {
                newCount = count + 1;
            }
            
            res = res + solve(pos + 1, newCount, newF, digits);
        }
        
        return digitDp[pos][count][f]= res;
    }
    
    public int countDigitOne(int n) {
        digitDp = new int[10][10][2];
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 2; k++) {
                    digitDp[i][j][k] = -1;
                }
            }
        }
        
        int[] digits = getDigits(n);
        return solve(0, 0, 0, digits);
    }
    
    private int[] getDigits(int num) {
        List<Integer> list = new ArrayList<>();
        
        while(num > 0) {
            list.add(num % 10);
            num = num / 10;
        }
        
        int[] digits = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            digits[i] = list.get(list.size() - i - 1);
        }
        
        return digits;
    }
}