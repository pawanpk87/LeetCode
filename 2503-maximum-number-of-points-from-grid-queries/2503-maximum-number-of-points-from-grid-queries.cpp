class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        int m = grid.size();
        int n = grid[0].size();
        
        vector<pair<int, int>> point; 
        
        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<>> pq;
        
        pq.emplace(grid[0][0], 0, 0); 
        grid[0][0] = 0; 
        
        int prefix = 0, prev = INT_MIN;
        
        int dir[5] = {-1, 0, 1, 0, -1};
        
        while (pq.size()) {
            auto [v, i, j] = pq.top(); pq.pop(); 
            if (prev != v) point.emplace_back(prev, prefix); 
            ++prefix; 
            prev = v; 
            for (int k = 0; k < 4; ++k) {
                int ii = i + dir[k], jj = j + dir[k+1]; 
                if (0 <= ii && ii < m && 0 <= jj && jj < n && grid[ii][jj]) {
                    int vv = max(v, grid[ii][jj]); 
                    pq.emplace(vv, ii, jj); 
                    grid[ii][jj] = 0; 
                }
            }
        }
        
        point.emplace_back(prev, prefix); 
        
        vector<int> ans; 
        
        for (auto& q : queries) {
            auto it = lower_bound(point.begin(), point.end(), make_pair(q, 0));            
            ans.push_back((--it)->second); 
        }
        
        return ans; 
    }
};