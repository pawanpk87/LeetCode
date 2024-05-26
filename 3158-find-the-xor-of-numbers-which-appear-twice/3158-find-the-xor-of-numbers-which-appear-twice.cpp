class Solution {
public:
    int duplicateNumbersXOR(vector<int>& nums) {
        unordered_map<int, int> mp;
        for(auto& num : nums) mp[num]++;
        int xorNum = 0;
        for(auto& data : mp){
            if(data.second > 1){
                xorNum = xorNum ^ data.first;
            }
        }
        return xorNum;
    }
};