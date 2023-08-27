class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        int n = pairs.size();
        
        sort(pairs.begin(),pairs.end());
        
        int maxPair = 1;
        vector<int> dp(n,1);
        
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(pairs[j][1]<pairs[i][0] && dp[i] < dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            maxPair = max(maxPair,dp[i]);
        }
        
        return maxPair;
    }
};