class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        sort(events.begin(),events.end());
        map<int,int> mp;
        int maxi=0;
        int ans=0;
        int size=events.size();
        while(size--)
        {
            auto it=mp.upper_bound(events[size][1]);
            maxi=max(maxi,events[size][2]);
            mp[events[size][0]]=maxi;
            if(it==mp.end())
               ans=max(ans,maxi);
            else
            {
                ans=max(ans,events[size][2]+it->second);
            }
        }
        return ans;
    }
};