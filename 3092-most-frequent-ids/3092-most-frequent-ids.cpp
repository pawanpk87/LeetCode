class Solution {
public:
    vector<long long> mostFrequentIDs(vector<int>& nums, vector<int>& freq) {
        int n = nums.size();
        
        unordered_map<long long, long long> mp;
        priority_queue<pair<long long, long long>> maxHeap;
        
        vector<long long> ans;
        
        for(int i = 0; i < n; i++){
            mp[nums[i]] += freq[i];
            maxHeap.push({mp[nums[i]], nums[i]});
            while(maxHeap.size() > 0 && mp[maxHeap.top().second] != maxHeap.top().first){
                maxHeap.pop();
            }
            ans.push_back(maxHeap.top().first);
        }
        
        return ans;
    }
};