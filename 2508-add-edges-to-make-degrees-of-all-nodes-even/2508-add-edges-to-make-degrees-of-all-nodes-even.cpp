class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        unordered_map<int,unordered_set<int>> adjList;
        
        for(auto& edge : edges)
        {
            adjList[edge[0]].insert(edge[1]);
            adjList[edge[1]].insert(edge[0]);
        }
        
        vector<int> odd;
        
        for(int i=1; i<=n; i++)
        {
            if(adjList[i].size()%2 != 0)
                odd.push_back(i);
        }
        
        if(odd.size() == 2)
        {
            for(int i=1; i<=n; i++)
            {
                if(adjList[odd[0]].count(i) == 0 &&
                   adjList[odd[1]].count(i) == 0)
                    return true;
            }
        }
        
        if(odd.size() == 4)
        {
            return (adjList[odd[0]].count(odd[1]) == 0 && adjList[odd[2]].count(odd[3]) == 0) ||
                   (adjList[odd[0]].count(odd[2]) == 0 && adjList[odd[1]].count(odd[3]) == 0) ||
                   (adjList[odd[0]].count(odd[3]) == 0 && adjList[odd[1]].count(odd[2]) == 0);
        }
        
        return odd.size() == 0;
    }
};