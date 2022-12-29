class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        
        vector<int> LIS;
        
        for(auto& num : nums)
        {
            auto it=lower_bound(LIS.begin(),LIS.end(),num);
            
            if(it == LIS.end())
                LIS.push_back(num);
            else
                *it=num;
        }
        
        return LIS.size();
    }
};