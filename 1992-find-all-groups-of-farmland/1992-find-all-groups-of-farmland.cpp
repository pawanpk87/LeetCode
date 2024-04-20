class Solution {
private:
    bool isValid(int currRow, int currCol, int n, int m){
        return currRow >= 0 && currCol >= 0 &&
               currRow < n && currCol < m;
    }
    
    void dfs(int currRow, int currCol, vector<vector<int>>& land, int& r1, int&c1, int& r2, int& c2, int n, int m){
        if(isValid(currRow, currCol, n, m) && land[currRow][currCol] == 1){
            r1 = min(r1, currRow);
            c1 = min(c1, currCol);
            r2 = max(r2, currRow);
            c2 = max(c2, currCol);
            
            land[currRow][currCol] = -1;
            
            dfs(currRow, currCol+1, land, r1, c1, r2, c2, n, m);
            dfs(currRow, currCol-1, land, r1, c1, r2, c2, n, m);
            dfs(currRow+1, currCol, land, r1, c1, r2, c2, n, m);
            dfs(currRow-1, currCol, land, r1, c1, r2, c2, n, m);
        }
    }
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        int n = land.size();
        int m = land[0].size();
        
        vector<vector<int>> farmalndPos;
        
        int r1, c1, r2, c2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1){
                    r1 = INT_MAX;
                    c1 = INT_MAX;
                    r2 = INT_MIN;
                    c2 = INT_MIN;
                    
                    dfs(i, j, land, r1, c1, r2, c2, n, m);
                    farmalndPos.push_back({r1, c1, r2, c2});
                }
            }
        }
        
        return farmalndPos;
    }
};