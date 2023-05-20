class Solution {
private:
    vector<vector<int>> memo;
    
    bool solve(int i,int j,string& s,string& p){
        if(j >= p.size())
            return i >= s.size();
        
        if(memo[i][j] != -1)
            return memo[i][j];
        
        bool firstMatch = (i < s.size() && (s[i] == p[j] || p[j] == '.'));
        
        if(j+1 < p.size() && p[j+1] == '*'){
            return memo[i][j] = (solve(i,j+2,s,p) ||
                                 (firstMatch && solve(i+1,j,s,p)));
        }else{
            return memo[i][j] = (firstMatch && solve(i+1,j+1,s,p));
        }
    }
public:
    bool isMatch(string s, string p) {
        memo.resize(21,vector<int>(21,-1));
        return solve(0,0,s,p);
    }
};