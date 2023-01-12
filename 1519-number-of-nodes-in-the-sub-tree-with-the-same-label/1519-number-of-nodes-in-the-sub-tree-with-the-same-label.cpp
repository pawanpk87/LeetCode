class Solution {
private:
    void traverse(int currNode,vector<int> adjList[],string& labels,vector<bool>& visited,unordered_map<char,int>& labelCount,vector<int>& res)
    {
        if(visited[currNode])
            return;
        
        visited[currNode] = true;
        
        int prevCount = labelCount[labels[currNode]];
        
        for(auto& adjNode : adjList[currNode])
        {
            if(visited[adjNode] == false)
                traverse(adjNode,adjList,labels,visited,labelCount,res);
        }
        
        labelCount[labels[currNode]]++;
        
        int finalCount = labelCount[labels[currNode]] - prevCount;
        
        res[currNode] = finalCount;
    }
    
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        vector<int> adjList[n];
        
        for(auto& edge : edges)
        {
            int u=edge[0], v=edge[1];
            adjList[u].push_back(v);
            adjList[v].push_back(u);
        }
        
        vector<int> res(n,1);
        vector<bool> visited(n,false);
        unordered_map<char,int> labelCount;
        
        traverse(0,adjList,labels,visited,labelCount,res);
        
        return res;
    }
};