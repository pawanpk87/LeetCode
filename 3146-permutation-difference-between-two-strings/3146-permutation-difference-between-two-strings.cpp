class Solution {
public:
    int findPermutationDifference(string s, string t) {
        int n = s.size();
        unordered_map<char, int> mps, mpt;
        for(int i = 0; i < n; i++){
            mps[s[i]] = i;
        }
        for(int i = 0; i < n; i++){
            mpt[t[i]] = i;
        }
        int diff = 0;
        for(auto& data : mps){
            diff += abs(data.second - mpt[data.first]);
        }
        return diff;
    }
};