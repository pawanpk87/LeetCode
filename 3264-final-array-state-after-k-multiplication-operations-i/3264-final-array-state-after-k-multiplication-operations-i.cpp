class Solution {
public:
    vector<int> getFinalState(vector<int>& nums, int k, int multiplier) {
        int MOD = 1000000007;
        
        int n = nums.size();
        
        map<int, set<int>> mp;
        for(int i = 0; i < n; i++) {
            mp[nums[i]].insert(i);
        }
        
        while(k-- && mp.size() > 0) {
            long minNum = mp.begin()->first;
            int minNumIndex = *(mp[minNum].begin());
            mp[minNum].erase(minNumIndex);
            if(mp[minNum].size() == 0) {
                mp.erase(minNum);
            }
            int newNum = (minNum * (long)multiplier) % MOD;
            mp[newNum].insert(minNumIndex);
        }
        
        for(auto& data : mp) {
            int num = data.first;
            for(int i : data.second) {
                nums[i] = num;
            }
        }
        
        for(int i = 0; i < n; i++) {
            nums[i] = (nums[i] % MOD);
        }
        
        return nums;
    }
};