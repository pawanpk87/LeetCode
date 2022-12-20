class Solution {
private:
    void dfs(int currNode,vector<int>& edges,vector<bool>& visited,vector<int>& path,int& maxLen)
    {
        if(currNode == -1)
            return;
        
        if(visited[currNode])
        {
            int currIndex=-1;
            for(int i=0; i<path.size(); i++)
            {
                if(path[i] == currNode)
                {
                    currIndex=i;
                    break;
                }
            }
            
            if(currIndex == -1)
                return;
            
            maxLen=max(maxLen,(int)(path.size()-currIndex));
            
            return;
        }
        
        visited[currNode]=true;
        path.push_back(currNode);
        dfs(edges[currNode],edges,visited,path,maxLen);
    }
    
public:
    int longestCycle(vector<int>& edges) {
        int n=edges.size();
        int maxLen=-1;
        
        vector<bool> visited(n,false);
        
        for(int i=0; i<n; i++)
        {
            if(visited[i])
                continue;
            vector<int> path;
            dfs(i,edges,visited,path,maxLen);
        }
        
        return maxLen;
    }
};