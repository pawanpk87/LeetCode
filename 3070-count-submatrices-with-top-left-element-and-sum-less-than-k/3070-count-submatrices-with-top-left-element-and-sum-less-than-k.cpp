class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        
        int count = 0;
        
        if(grid[0][0] <= k){
            count++;
        }
        
        for(int i = 1; i < n; i++){
            grid[i][0] += grid[i-1][0];
            if(grid[i][0] <= k){
                count++;
            }
        }
        
        for(int j = 1; j < m; j++){
            grid[0][j] += grid[0][j-1];
            if(grid[0][j] <= k){
                count++;
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                int sum1 = grid[i-1][j];
                int sum2 = grid[i][j-1];
                int sum = (sum1 + sum2 - grid[i-1][j-1]) + grid[i][j];
                grid[i][j] = sum;
                if(sum <= k){
                    count++;
                }
            }
        }
        
        return count;
    }
};