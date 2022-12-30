class Solution {
private:
    void dfs(int currNode,vector<int> adjList[],vector<int>& currPath,vector<vector<int>>& res,int n)
    {
        currPath.push_back(currNode);
        if(currNode == n-1)
        {
            res.push_back(currPath);
        }
        else
        {
            for(auto& adjNode : adjList[currNode])
            {                
                dfs(adjNode,adjList,currPath,res,n);                
            }            
        }
        currPath.pop_back();
    }
    
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        int n=graph.size();   
        
        vector<int> adjList[n];
        for(int node=0; node<n; node++)
        {
            for(auto& edge : graph[node])
            {
                adjList[node].push_back(edge);
            }
        }  
        
        vector<vector<int>> res;
        vector<int> currPath;  
        
        dfs(0,adjList,currPath,res,n);   
    
        return res;
    }
};