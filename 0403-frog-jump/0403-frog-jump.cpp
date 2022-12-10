class Solution {
public:
    bool canCross(vector<int>& stones) {
        map<int,unordered_set<int>> mp;
        
        for(auto& stone : stones)
        {
            mp[stone]=unordered_set<int> {};
        }
        
        mp[stones[0]].insert(1);
        
        int target=stones[stones.size()-1];
        
        for(auto& stone : stones)
        {
            for(auto& step : mp[stone])
            {
                int reach=step+stone;
                
                if(reach == target)
                    return true;
                
                mp[reach].insert(step+1);
                mp[reach].insert(step);
                if(step > 0)
                    mp[reach].insert(step-1);
            }
        }
        
        return false;
    }
};