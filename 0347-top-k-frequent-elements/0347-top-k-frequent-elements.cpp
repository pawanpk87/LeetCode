class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> freq;
        for(auto& num : nums){
            freq[num]++;
        }
        
        priority_queue<pair<int,int>,
                       vector<pair<int,int>>,
                       greater<pair<int,int>>> minHeap;
        
        for(auto& data : freq){
            minHeap.push({data.second,data.first});
            if(minHeap.size() > k){
                minHeap.pop();
            }
        }
        
        vector<int> result;
        while(!minHeap.empty()){
            result.push_back(minHeap.top().second);
            minHeap.pop();
        }
        
        reverse(result.begin(),result.end());
        
        return result;        
    }
};