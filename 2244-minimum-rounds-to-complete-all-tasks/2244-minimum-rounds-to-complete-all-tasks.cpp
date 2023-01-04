class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        unordered_map<int,int> mp;
        
        for(auto task : tasks)
        {
            mp[task]++;
        }
        
        int count=0;
        
        for(auto& data : mp)
        {
            if(data.second == 1)
                return -1;
            
            if(data.second%3 == 0)
                count+=data.second/3;
            else
            {
                count+=data.second/3+1;
            }
        }
        
        return count;
    }
};