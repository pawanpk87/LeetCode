class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        vector<int> refund;
        
        int sum=0;
        
        for(auto& cost : costs)
        {
            sum+=cost[0];
            refund.push_back(cost[1]-cost[0]);
        }
        
        sort(refund.begin(),refund.end());
        
        for(int i=0; i<(costs.size()/2); i++)
        {
            sum+=refund[i];
        }
        
        return sum;
    }
};