class Solution {
public:
    vector<int> minimumTime(int n, vector<vector<int>>& edges, vector<int>& disappear) {
        vector<pair<int, int>> adjList[n];
        
        int u, v, wt;
        for(auto& edge : edges){
            u = edge[0], v = edge[1], wt = edge[2];
            adjList[u].push_back({v, wt});
            adjList[v].push_back({u, wt});
        }
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
        vector<int> minTime(n, -1);
        vector<bool> visited(n, false);
        
        minHeap.push({0, 0});
        minTime[0] = 0;
        
        while(!minHeap.empty()){
            int currTime = minHeap.top().first;
            int currNode = minHeap.top().second;
            minHeap.pop();
            
            if(visited[currNode]){
                continue;
            }
            
            visited[currNode] = true;
            
            for(auto& node : adjList[currNode]){
                int adjNode = node.first;
                int nextTime = currTime + node.second;
                if(nextTime < disappear[adjNode] && 
                   (minTime[adjNode] == -1 || nextTime < minTime[adjNode])){
                    minHeap.push({nextTime, adjNode});
                    minTime[adjNode] = nextTime;
                }
            }
        }
        
        return minTime;
    }
};