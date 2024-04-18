class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        int landCount = 0;
        int connectedCell = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    landCount++;
                    connectedCell += getConnectedCell(grid, i, j, n, m);
                }
            }
        }
        
        return ((4 * landCount) - connectedCell);
    }
    
    int getConnectedCell(vector<vector<int>>& grid, int i, int j, int n, int m){
        int count = 0;
        int dx[4] = {1, -1, 0, 0};
        int dy[4] = {0, 0, 1, -1};
        for(int k = 0; k < 4; k++){
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1){
                count++;
            }
        }
        return count;
    }
};