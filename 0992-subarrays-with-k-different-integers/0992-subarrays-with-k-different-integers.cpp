class Solution {
private:
    int subarrayAtMost(vector<int>& nums, int k){
        int n = nums.size();
        int totalCount = 0;
        unordered_map<int, int> freq;
        int i = 0, j = 0;
        while(j < n){
            freq[nums[j]]++;
            while(freq.size() > k){
                freq[nums[i]]--;
                if(freq[nums[i]] == 0){
                    freq.erase(nums[i]);
                }
                i++;
            }
            totalCount += (j - i +1);
            j++;
        }
        return totalCount;
    }
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return subarrayAtMost(nums, k) - 
               subarrayAtMost(nums, k-1);
    }
};