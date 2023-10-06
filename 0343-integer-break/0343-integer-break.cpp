class Solution {
public:
    int solve(vector<int>& cost,int n,int target)
    {
        if(target==0 || n==0)
           return 1;
        if(cost[n-1] <= target)
        {
            return max(cost[n-1]*solve(cost,n,target-cost[n-1]),solve(cost,n-1,target));
        }
        else
        {
            return solve(cost,n-1,target);
        }
    } 
    int integerBreak(int n) {
        int i=1;
        vector<int> cost;
        while(i<=n-1)
        {
            cost.push_back(i++);
        }
        return solve(cost,cost.size(),n);
    }
};