int mod = 1e9 + 7;

class Solution {
private:
    vector<vector<vector<int>>> memo;
    
    int solve(int currIndex,int currMembersCount,int currProfit,int n, int minProfit, vector<int>& group, vector<int>& profit){
        if(currIndex == group.size()){
            return currProfit>= minProfit;
        }
        
        if(memo[currIndex][currMembersCount][currProfit] != -1)
            return memo[currIndex][currMembersCount][currProfit];
        
        int count = solve(currIndex+1,
                          currMembersCount,
                          currProfit,
                          n,
                          minProfit,
                          group,
                          profit);
        
        if(group[currIndex]+currMembersCount <= n){
            count += solve(currIndex+1,
                           group[currIndex]+currMembersCount,
                           min(minProfit,currProfit+profit[currIndex]),
                           n,
                           minProfit,
                           group,profit);
        }
        
        return memo[currIndex][currMembersCount][currProfit] = count%mod;
    }
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        int m = group.size();
        
        memo.resize(101,vector<vector<int>>(101,vector<int>(101,-1)));
        
        return solve(0,0,0,n,minProfit,group,profit);        
    }
};