class UnionFind
{
    private:
            vector<int> parent;
            vector<int> rank;
    public:
            UnionFind(int n)
            {
                parent.resize(n+1);
                rank.resize(n+1);
                for(int i=0; i<=n; i++)
                {
                    parent[i]=i;
                    rank[i]=0;
                }
            }
            
            int findParent(int node)
            {
                if(node == parent[node])
                    return node;
                return parent[node]=findParent(parent[node]);
            }
            
            void unionNode(int node1,int node2)
            {
                int prnt1=findParent(node1);
                int prnt2=findParent(node2);
                
                if(prnt1 == prnt2)
                    return;
                
                if(rank[prnt1] > rank[prnt2])
                {
                    parent[prnt2]=prnt1;
                }
                else if(rank[prnt1] > rank[prnt2])
                {
                    parent[prnt1]=prnt2;
                }
                else
                {
                    parent[prnt2]=prnt1;
                    rank[prnt1]++;
                }
            }
};

class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        int n=vals.size();
        
        vector<int> adjList[n];
        
        for(auto& edge : edges)
        {
            int u=edge[0], v=edge[1];
            adjList[u].push_back(v);
            adjList[v].push_back(u);
        }
        
        map<int,vector<int>> similarValNodes;
        
        for(int node=0; node<n; node++)
        {
           similarValNodes[vals[node]].push_back(node); 
        }
        
        UnionFind dsu(n+1);
        
        int goodPaths=0;
        
        for(auto& data : similarValNodes)
        {
            for(int node : data.second)
            {
                for(auto& adjNode : adjList[node])
                {
                    if(vals[node] >= vals[adjNode])
                    {
                        dsu.unionNode(node,adjNode);
                    }
                }
            }
            
            unordered_map<int,int> group;
            
            for(int node : data.second)
            {
                group[dsu.findParent(node)]++;
            }
            
            for(auto& [_,size] : group)
            {
                goodPaths += (size * (size + 1)/2);
            }            
        }
        
        return goodPaths;
    }
};