class Solution {
public:
    int maxOperations(string s) {
        int n = s.size();
        int res = 0;
        int ones = 0;
        int i = 0;
        while(i < n) {
            while(i < n && s[i] == '1') {
                ones++;
                i++;
            }
            
            if(i > 0 && i < n && s[i-1] == '1' && s[i] == '0') {
                res += ones;
            }
            
            i++;
        }
        return res;
    }
};