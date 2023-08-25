class Solution {
private:
    vector<vector<int>> memo;
public:
    bool solve(string& s1, string& s2, int currI, int currJ, int currK, string& s3){        
        if(currI == s1.size()){
            while(currJ<s2.size()){
                if(s2[currJ++] != s3[currK++]){
                    return false;
                }
            }
            return currK == s3.size() && currJ == s2.size();
        }
        
        if(currJ == s2.size()){
            while(currI<s1.size()){
                if(s1[currI++] != s3[currK++]){
                    return false;
                }
            }
            return currK == s3.size() && currI == s1.size();
        }
        
        if(memo[currI][currJ] != -1){
            return memo[currI][currJ];
        }
        
        bool opt1 = false, opt2 = false;
        
        if(s1[currI] == s3[currK]){
            opt1 = solve(s1,s2,currI+1,currJ,currK+1,s3);
        }
        
        if(s2[currJ] == s3[currK]){
            opt2 = solve(s1,s2,currI,currJ+1,currK+1,s3);
        } 
        
        return memo[currI][currJ] = opt1 | opt2;
    }
    
    bool isInterleave(string s1, string s2, string s3) {
        memo.resize(s1.size(),vector<int>(s2.size(),-1));
        return solve(s1,s2,0,0,0,s3);   
    }
};