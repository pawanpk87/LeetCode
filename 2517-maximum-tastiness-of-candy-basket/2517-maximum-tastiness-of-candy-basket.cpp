class Solution {
private:
    bool isPossible(vector<int>& price,int diff,int k)
    {
        int currIndex=0, lastNum=price[0], count=1;
        while(currIndex<price.size() && count<k)
        {
            if((price[currIndex]-lastNum) >= diff)
            {
                lastNum=price[currIndex];
                count++;
            }
            currIndex++;
        }
        return count == k;
    }
    
public:
    int maximumTastiness(vector<int>& price, int k) {
        sort(price.begin(),price.end());
        int left=0, right=1000000000;
        while(left < right)
        {
            int mid=(left+right)/2;
            if(isPossible(price,mid,k))
                left=mid+1;
            else
                right=mid;
        }
        return left-1;
    }
};