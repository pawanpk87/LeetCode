class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        vector<long long> degree(n, 0);
        int u, v;
        for(auto& road : roads){
            u = road[0], v = road[1];
            degree[v]++;
            degree[u]++;
        }
        
        sort(degree.begin(), degree.end());
        
        long long value = 1;
        long long totalImportance = 0;
        
        for(long long d : degree){
            totalImportance += (value * d);
            value++;
        }
        
        return totalImportance;
    }
};