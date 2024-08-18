class Solution {
    private boolean isKConstraintSubStr(String s, int k) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        return zeros <= k || ones <= k;
    }
    
    public int countKConstraintSubstrings(String s, int max) {
        int n = s.length();
        int count = 0;
        for (int k = 1; k <= n; k++)
        {
            for (int i = 0, j = k - 1; j < n; i++, j++)
            {
                StringBuilder sb = new StringBuilder();
                
                for (int l = i; l <= j; l++)
                {
                    sb.append(s.charAt(l));
                }
                
                if(isKConstraintSubStr(sb.toString(), max)) {
                    count++;
                }
            }
        }
        return count;
    }
}