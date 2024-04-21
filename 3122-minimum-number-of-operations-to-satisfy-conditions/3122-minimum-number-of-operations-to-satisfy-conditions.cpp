class Solution {
private:
    int solve(int currColumn, int prevNum, vector<vector<int>>& operationsReq, vector<vector<int>>& dp, int m){
        if(currColumn == m){
            return 0;
        }
        
        if(prevNum != -1 && dp[currColumn][prevNum] != -1){
            return dp[currColumn][prevNum];
        }
        
        int minOperations = INT_MAX;
        for(int nextNum = 0; nextNum <= 9; nextNum++){
            if(nextNum != prevNum){
                int currOperations = operationsReq[currColumn][nextNum] + solve(currColumn+1, nextNum, operationsReq, dp, m);
                minOperations = min(minOperations, currOperations);
            }
        }
        
        if(prevNum != -1){
            dp[currColumn][prevNum] = minOperations;
        }
        
        return minOperations;
    }
public:
    int minimumOperations(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        
        vector<vector<int>> freq(m, vector<int>(10, 0));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                freq[j][grid[i][j]]++;
            }
        }
        
        vector<vector<int>> operationsReq(m, vector<int>(10, 0));
        for(int j = 0; j < m; j++){
            for(int num = 0; num <= 9; num++){
                operationsReq[j][num] = n - freq[j][num];
            }
        }
        
        vector<vector<int>> dp(m+1, vector<int>(10, -1));
        
        return solve(0, -1, operationsReq, dp, m);
    }
};