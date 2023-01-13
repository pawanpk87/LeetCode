class Solution {
private:
    int ans=0;
    
    int dfs(int currNode,vector<int> adjList[],string& s)
    {
        int max1=0, max2=0;
        
        for(auto& adjNode : adjList[currNode])
        {
            if(s[currNode] != s[adjNode])
            {
                int tempLen=1+dfs(adjNode,adjList,s);
                
                if(max1 < tempLen)
                {
                    max2=max1;
                    max1=tempLen;
                }
                else if(max2 < tempLen)
                {
                    max2=tempLen;
                }
            }
            else
            {
                ans=max(ans,dfs(adjNode,adjList,s));
            }
        }
        
        if(max1!=0 && max2!=0)
            ans=max(ans,max1+max2);
        
        return max(max1,max2);
    }
    
public:
    
    int longestPath(vector<int>& parent, string s) {
        int n=parent.size();
        
        vector<int> adjList[n];
        
        for(int i=1; i<n; i++)
        {
            adjList[parent[i]].push_back(i);
        }
        
        ans=max(ans,dfs(0,adjList,s));
        
        return ans+1;
    }
};