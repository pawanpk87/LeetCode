class Solution {
private:
    unordered_map<string,bool> memo;

    bool solve(string s1,string s2){
        if(s1 == s2){
            return true;
        }

        if(s1.size() != s2.size()){
            return false;
        }

        string key = s1+"-"+s2;

        if(memo.find(key) != memo.end())
            return memo[key];
        
        int n = s1.size();
        bool result = false;

        for(int i=1; i<n; i++){
            bool withSwap = (solve(s1.substr(0,i),s2.substr(n-i,i)) &&
                             solve(s1.substr(i,n-i),s2.substr(0,n-i)));
            if(withSwap){
                result = true;
                break;
            }

            bool withoutSwap = (solve(s1.substr(0,i),s2.substr(0,i)) &&
                                solve(s1.substr(i,n-i),s2.substr(i,n-i)));
            if(withoutSwap){
                result = true;
                break;
            }
        }

        return memo[key] = result;
    }
public:
    bool isScramble(string s1, string s2) {
        memo.clear();
        return solve(s1,s2);
    }
};