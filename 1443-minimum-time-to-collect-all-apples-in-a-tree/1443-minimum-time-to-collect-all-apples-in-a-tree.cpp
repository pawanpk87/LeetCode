class Solution {
private:
    int dfs(int currNode,vector<int> adjList[],vector<bool>& visited,vector<bool>& hasApple)
    {
        visited[currNode] = true;
        
        int res=0;
        
        for(auto& adjNode : adjList[currNode])
        {
            if(!visited[adjNode])
            {
                res+=dfs(adjNode,adjList,visited,hasApple);
            }
        }
        
        if((res!=0 || hasApple[currNode]) && currNode != 0)
            return res+2;
        
        return res;
    }
    
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        vector<int> adjList[n];
        
        for(auto& edge : edges)
        {
            int u = edge[0], v = edge[1];
            adjList[u].push_back(v);
            adjList[v].push_back(u);
        }
        
        vector<bool> visited(n,false);
        
        return dfs(0,adjList,visited,hasApple);
    }
};