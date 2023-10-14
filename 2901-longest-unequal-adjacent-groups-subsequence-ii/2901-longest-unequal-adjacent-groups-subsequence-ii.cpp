class Solution {
private: 
    int hammingDistance(string word1, string word2){
        int count = 0;
        for(int i = 0; i < min(word1.size(), word2.size()); i++){
            if(word1[i] != word2[i])
                count++;
            if(count > 1)
                break;
        }
        return count;
    }
public:
    vector<string> getWordsInLongestSubsequence(int n, vector<string>& words, vector<int>& groups) {
        vector<vector<string>> dp(n);
        
        for(int i = 0; i < n; i++){
            dp[i].push_back(words[i]);
        }
        
        int maxLen = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(words[i].size() == words[j].size() &&
                   hammingDistance(words[i], words[j]) == 1 &&
                   groups[i] != groups[j]){
                   if(dp[i].size() < dp[j].size() + 1){
                       dp[i] = dp[j];
                       dp[i].push_back(words[i]);
                       maxLen = max(maxLen, (int)dp[i].size());
                   }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(dp[i].size() == maxLen){
                return dp[i];
            }
        }
        
        return {};
    }
};