#define LIMIT 1000001
long long prime_flag[LIMIT];

void calculatePrime()
{
    prime_flag[0] = prime_flag[1] = 1;
    for (long long i = 2; i < LIMIT; i++)
    {
        if (prime_flag[i] == 0)
        {
            for (long long j = i * i; j < LIMIT; j += i)
            {
                prime_flag[j] = 1;
            }
        }
    }
}

class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        calculatePrime();
        
        int ans1=-1, ans2=-1;
        
        int res1=-1,res2=-1;
        
        int minNum=INT_MAX;
        
        for(int i=left; i<=right; i++)
        {
            if(prime_flag[i] == 0)
            {
                if(ans1 == -1)
                    ans1=i;
                else if(ans2 == -1) 
                {
                    ans2=i;
                    minNum=ans2-ans1;
                    res1=ans1;
                    res2=ans2;
                }
                
                if(ans1!=-1 && ans2!=-1)
                {
                    if(ans2 < i)
                    {
                        ans1=ans2;
                        ans2=i;
                    }
                    if(minNum > (ans2-ans1))
                    {
                        res1=ans1;
                        res2=ans2;
                        minNum=(ans2-ans1);
                    }
                }
            }
        }
        
        if(minNum == INT_MAX)
            return {-1,-1};
        
        return {res1,res2};
    }
};