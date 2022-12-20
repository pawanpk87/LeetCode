class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        vector<pair<int,int>> adj[n+1];
        for(int i=0; i<times.size(); i++)
        {
            adj[times[i][0]].push_back({times[i][1],times[i][2]});
        }
        
        queue<pair<int,int>> q;
        vector<int> values(n+1,INT_MAX);
        values[k]=0;
        q.push({k,0});
        
        while(!q.empty())
        {
            int nodes=q.front().first;
            int time=q.front().second;
            q.pop();
            vector<pair<int,int>> v(adj[nodes].begin(),adj[nodes].end());
            if(v.size() > 0)
            {
                for(int i=0; i<v.size(); i++)
                {
                    if(values[v[i].first] > values[nodes]+v[i].second)
                    {
                        values[v[i].first]=values[nodes]+v[i].second;
                        
                        q.push({v[i].first,values[v[i].first]});                        
                    }
                }
            }            
        }
        
        int ans=INT_MIN;
        for(int i=1; i<n+1; i++)
        {
            if(values[i] == INT_MAX) return -1;
            ans=max(ans,values[i]);
        }
        
        return ans;       
    }
};