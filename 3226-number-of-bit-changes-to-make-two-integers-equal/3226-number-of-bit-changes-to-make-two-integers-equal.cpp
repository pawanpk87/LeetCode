class Solution {
public:
    int minChanges(int n, int k) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            int a = k & 1;
            int b = n & 1;
           
            if(b == 1 && a == 0) {
                count++;
            } else if(b == 0 && a == 1) {
                return -1;
            }
            k = k>>1;
            n = n>>1;
        }
        return count;
    }
};