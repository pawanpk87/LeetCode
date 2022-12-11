class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        unordered_map<long long,int> mp;
        for(int num : nums)
        {
            mp[num]=1;
        }
        
        for(int i=nums.size()-2; i>=0; i--)
        {
            if(nums[i] == nums[i+1])
                continue;
            
            long long int result=(long long)nums[i];
            result *= (long long)nums[i];
            
            if(mp.find(result)!= mp.end())
            {
               mp[nums[i]]=mp[nums[i]]+mp[result]; 
            }
               
        }
        
        int count=-1;
        for(auto& data : mp)
        {
            count=max(count,data.second);
        }
        
        return count == 1 ? -1 : count;
    }
};