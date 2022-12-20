class Solution {
public:
    int smallestValue(int n,int s=0) {
        
        for (int i = 2, m = n; i <= n; i++)
        {
            for(; m % i == 0; )
            {
                s += i, m /= i;
            }
        }
        
        return s == n ? n : smallestValue(s);
    }
};