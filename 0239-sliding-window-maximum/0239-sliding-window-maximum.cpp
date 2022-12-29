class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n=nums.size();
        vector<int> res;
        map<int,int,greater<int>> freq;
        int i=0,j=0;
        while(j<n)
        {
            freq[nums[j]]++;
            if((j-i+1) == k)
            {
                res.push_back(freq.begin()->first);
                if(freq[nums[i]] > 1)
                    freq[nums[i]]--;
                else
                    freq.erase(nums[i]);
                i++;
            }
            j++;
        }
        return res;
    }
};