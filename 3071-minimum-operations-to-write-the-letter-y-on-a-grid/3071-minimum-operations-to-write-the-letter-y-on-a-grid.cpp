class Solution {
private:
    int countOperations(vector<vector<int>> grid, int y, int notY){
        int n = grid.size();
        int operations = 0;
        
        for(int i = 0; i < (n/2); i++){
            if(grid[i][i] != y){
                operations++;
            }
            grid[i][i] = -1;
        }
        
        for(int i = 0, j = n-1; i < (n/2); i++, j--){
            if(grid[i][j] != y){
                operations++;
            }
            grid[i][j] = -1;
        }
        
        for(int i = n/2; i < n; i++){
            int j = n/2;
            if(grid[i][j] != y){
                operations++;
            }
            grid[i][j] = -1;
        }
        
        
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         cout<<grid[i][j]<< " ";
        //     }
        //     cout<<endl;
        // }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != -1 && grid[i][j] != notY){
                    operations++;
                }
            }
        }
        
        return operations;
    }
    
public:
    int minimumOperationsToWriteY(vector<vector<int>>& grid) {
        int minOperations = INT_MAX;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j) continue;
                minOperations = min(minOperations, countOperations(grid, i, j));
            }
        }
        return minOperations;
    }
};