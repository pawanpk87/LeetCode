class Solution {
private:
    int dfs(int currNode, int currNodeParent, vector<int> adjList[], set<int>& restrictedNodes){
        if(restrictedNodes.count(currNode) > 0){
            return 0;
        }
        int totalCount = 0;
        for(auto& adjNode : adjList[currNode]){
            if(adjNode != currNodeParent){
                totalCount += dfs(adjNode, currNode, adjList, restrictedNodes);
            }
        }
        return 1 + totalCount;
    }
public:
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        vector<int> adjList[n];
        int u, v;
        for(auto& edge : edges){
            u = edge[0], v = edge[1];
            adjList[u].push_back(v);
            adjList[v].push_back(u);
        }
        
        set<int> restrictedNodes(restricted.begin(), restricted.end());
        
        int count = dfs(0, -1, adjList, restrictedNodes);
        
        return count;
    }
};