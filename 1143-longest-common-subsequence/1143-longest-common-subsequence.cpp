class Solution {
private:
    vector<vector<int>> memo;
    
    int solve(int n,int m,string& text1,string& text2){
        if(n == 0 || m == 0)
            return 0; 
        
        if(memo[n-1][m-1] != -1)
            return memo[n-1][m-1];
        
        if(text1[n-1] == text2[m-1]){
            return memo[n-1][m-1] =  1 + solve(n-1,m-1,text1,text2);
        }else{
            return memo[n-1][m-1] = max(solve(n-1,m,text1,text2),
                                        solve(n,m-1,text1,text2));
        }
    }
public:
    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.size();
        int m = text2.size();
        memo.resize(n,vector<int>(m,-1));
        return solve(text1.size(),text2.size(),text1,text2);
    }
};
