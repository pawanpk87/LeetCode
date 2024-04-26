class Solution {
private:
    int solve(int currRow, int prevCol, vector<vector<int>>& grid, vector<vector<int>>& memo, int rowSize, int colSize){
        if(prevCol >= 0 && memo[currRow][prevCol] != INT_MAX){
            return memo[currRow][prevCol];
        }
        
        int minSum = INT_MAX;
        for(int col = 0; col < colSize; col++){
            if(col != prevCol){
                if(currRow == rowSize-1){
                    minSum = min(minSum, 
                                 grid[currRow][col]);
                } else{
                    minSum = min(minSum, grid[currRow][col] 
                                         + solve(currRow+1, col, grid, memo, rowSize, colSize));
                }
            }
        }
        
        if(prevCol >= 0){
            return memo[currRow][prevCol] = minSum;
        } else{
            return minSum;
        }
    }
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        int rowSize = grid.size(), colSize = grid[0].size();
        vector<vector<int>> memo(rowSize, vector<int>(colSize, INT_MAX));
        return solve(0, -1, grid, memo, rowSize, colSize);
    }
};