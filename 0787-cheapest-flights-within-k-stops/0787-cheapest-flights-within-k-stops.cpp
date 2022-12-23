class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {        
        vector<pair<int,int>> adjList[n];
        for(auto& f : flights)
        {
            adjList[f[0]].push_back({f[1],f[2]});
        }
        
        vector<int> dist(n,INT_MAX);
        queue<pair<int,int>> bfs;

        bfs.push({src,0});
        
        int stops=0;
        
        while(stops <= k && !bfs.empty())
        {
            int level=bfs.size();
            while(level--)
            {
                int currNode=bfs.front().first;
                int currCost=bfs.front().second;
                
                bfs.pop();
                
                for(auto& adjNode : adjList[currNode])
                {
                    int nextNode=adjNode.first;
                    int nextCost=currCost+adjNode.second;
                    
                    if(nextCost < dist[nextNode])
                    {
                        dist[nextNode]=nextCost;
                        bfs.push({nextNode,nextCost});
                    }
                }
            }
            stops++;
        }
        
        return dist[dst] == INT_MAX ? -1 : dist[dst];
    }
};