class Solution {
private:
    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.size();
        int m = text2.size();
        
        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(text1[i-1] == text2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
public:
    int longestPalindromeSubseq(string s) {
        string text1 = s;
        string text2 = s;
        
        reverse(text2.begin(),text2.end());
        
        return longestCommonSubsequence(text1,text2);
    }
};
