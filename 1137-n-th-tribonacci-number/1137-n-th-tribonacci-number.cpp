class Solution {
public:
    int tribonacci(int n) {
        if(n <= 2){
            return n == 0 ? 0 : 1;
        }
        
        int prev1 = 0, prev2 = 1, prev3 = 1, next;
        n -= 2;
        while(n--){
            next = prev1 + prev2 + prev3;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = next;
        }
        
        return next;
    }
};