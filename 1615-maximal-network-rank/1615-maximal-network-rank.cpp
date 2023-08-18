class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        vector<int> degree(n,0);
        vector<vector<bool>> connected(n,vector<bool>(n,false));
        
        for(auto& road : roads){
            int e = road[0], v = road[1];
            
            connected[e][v] = true;
            connected[v][e] = true;
            
            degree[e]++;
            degree[v]++;
        }
        
        int maxNetwork = 0;
        
        for(int e = 0; e<n; e++){
            for(int v = e+1; v<n; v++){
                maxNetwork = max(maxNetwork, (degree[e] + degree[v] - (connected[e][v] ? 1 : 0)));
            }
        }
        
        return maxNetwork;
    }
};