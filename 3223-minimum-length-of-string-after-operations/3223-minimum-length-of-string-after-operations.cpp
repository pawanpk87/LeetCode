class Solution {
public:
    int minimumLength(string s) {
        unordered_map<char, int> mp;
        for(char& ch : s){
            mp[ch]++;
        }
        int count = 0;
        for(auto& data : mp){
            if(data.second > 1) {
                count += data.second%2 == 0 ? data.second - 2 : data.second - 1;
            }
        }
        return s.size() - count;
    }
};