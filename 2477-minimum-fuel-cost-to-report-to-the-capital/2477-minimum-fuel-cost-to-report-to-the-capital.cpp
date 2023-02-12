class Solution {
private:
    int dfs(int currNode,int prevNode,vector<int> adjList[],int& seats,long long& ans)
    {
        int people = 1;
        for(auto& adjNode : adjList[currNode])
        {
            if(prevNode != adjNode)
            {
                people += dfs(adjNode,currNode,adjList,seats,ans);
            }
        }
        
        if(currNode != 0)
        {
            ans += (people + seats -1)/seats;
        }
        
        return people;
    }
    
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        int n = roads.size();
        
        vector<int> adjList[n+1];
        for(auto& road : roads)
        {
            int u = road[0], v = road[1];
            adjList[u].push_back(v);
            adjList[v].push_back(u);
        }
        
        long long ans=0;
        
        dfs(0,-1,adjList,seats,ans);
        
        return ans;
    }
};