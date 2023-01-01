class Solution {
public:
    int minimumPartition(string s, int k) {
        long long int currNum=0;
        int count=0;
        int i=0,j=0;
        while(j<s.size())
        {
            currNum=currNum * 10 + s[j]-'0';
            if(currNum > k)
            {
                count++;
                currNum=s[j]-'0';
                if(currNum > k)
                    return -1;
            }            
            j++;
        }
        if(currNum != 0)
            count++;
        return count == 0 ? -1 : count;
    }
};