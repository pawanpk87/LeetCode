 int costType[] = {1,7,30};

class Solution {
private: 
    int solve(int currIndex,vector<int>& days,vector<int>& costs,vector<int>& memo){
        if(currIndex >= days.size())
            return 0;
        
        if(memo[currIndex] != -1)
            return memo[currIndex];
        
        int tempMinCost = INT_MAX;
        int j = currIndex;
        
        for(int k=0; k<3; k++){
            while(j<days.size() && days[j] < days[currIndex]+costType[k]){
               j++;
            }
            tempMinCost = min(tempMinCost,solve(j,days,costs,memo)+costs[k]);
        }
        
        return memo[currIndex] = tempMinCost;
    }
    
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days.size();
        vector<int> memo(n,-1);
        return solve(0,days,costs,memo);
    }
};