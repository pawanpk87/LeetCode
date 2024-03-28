class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        int n = nums.size();
        
        int maxSubarrayLen = 0;
        
        unordered_map<int, int> freq;
        int i = 0, j = 0;
        
        while(j < n){
            freq[nums[j]]++;
            
            while(freq[nums[j]] > k){
                freq[nums[i]]--;
                i++;
            }
            
            maxSubarrayLen = max(maxSubarrayLen, (j - i) + 1);
            
            j++;
        }
        
        return maxSubarrayLen;
    }
};