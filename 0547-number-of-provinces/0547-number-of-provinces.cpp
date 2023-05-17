class Solution {
private:
    void dfs(int currNode,vector<int> adjList[],vector<bool>& visited){
        visited[currNode] = true;
        for(auto& adjNode : adjList[currNode]){
            if(!visited[adjNode]){
                dfs(adjNode,adjList,visited);
            }
        }
    }
    
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        int m = isConnected[0].size();
        
        vector<int> adjList[n+1];
        int u,v;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(isConnected[i][j] && i!=j){
                   u = i+1, v = j+1;                   
                   adjList[u].push_back(v);
                   adjList[v].push_back(u);                   
               } 
            }            
        }
        
        int provinces = 0;
        
        vector<bool> visited(n+1,false);
        
        for(int node = 1; node<=n; node++){
            if(!visited[node]){
                dfs(node,adjList,visited);
                provinces++;
            }
        }
        
        return provinces;
    }
};