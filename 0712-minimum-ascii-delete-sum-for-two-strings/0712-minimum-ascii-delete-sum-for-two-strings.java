class Solution {
    int[][] memo;
    
    private int minimumDeleteSumUtil(int i, int j, String s1, String s2) {
        if(i == s1.length() || j == s2.length()) {
            int remAsciiNum = 0;
            
            while(i < s1.length()) {
                remAsciiNum += (int) s1.charAt(i);
                i++;
            }
            
            while(j < s2.length()) {
                remAsciiNum += (int) s2.charAt(j);
                j++;
            }
            
            return remAsciiNum;
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = minimumDeleteSumUtil(i + 1, j + 1, s1, s2);
        } else {
            return memo[i][j] = Math.min(((int) s1.charAt(i)) + minimumDeleteSumUtil(i + 1, j, s1, s2),
                                         ((int) s2.charAt(j)) + minimumDeleteSumUtil(i, j + 1, s1, s2));
        }
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return minimumDeleteSumUtil(0, 0, s1, s2);
    }
}
/*
    s1 = "sea", s2 = "eat"
          |           |
    
    115 "ea" "eat"     "sea" "at"
         |    |         |     |
            |           /       \
        
        "a" "at"
         |   |
           |
         "" "t"
           
           116
          
    s1 = "delete", s2 = "leet"
          |              |
    100 "elete" "leet"
         |       |
    101 "lete"  "leet"
         |       |
             |
        "ete" "eet"
         |     |
            |
        "te" "et"
         |    |
        
         "te"   "t"
            
    

*/