class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(costs.begin(),costs.end());
        int ans=0;
        int temp=coins;
        int j=0;
        while(j<costs.size())
        {
            if(costs[j]<=temp)
            {
                temp-=costs[j];
                ans++;
                j++;
            }
            else
                break;
        }
        return ans;
    }
};