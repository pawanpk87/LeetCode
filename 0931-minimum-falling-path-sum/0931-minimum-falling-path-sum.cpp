class Solution {
private:
    int solve(int row, 
              int col, 
              vector<vector<int>>& matrix, 
              vector<vector<int>>& memo,
              int rowSize,
              int colSize){
        if(isSafe(row, col, rowSize, colSize)){
            if(memo[row][col] != INT_MAX){
                return memo[row][col];
            }
            
            if(row == rowSize-1){
                return matrix[row][col];
            }
            
            int opt1 = solve(row+1, col-1, matrix, memo, rowSize, colSize);
            int opt2 = solve(row+1, col, matrix, memo, rowSize, colSize);
            int opt3 = solve(row+1, col+1, matrix, memo, rowSize, colSize);
            
            return memo[row][col] = matrix[row][col] + min({opt1, opt2, opt3});
        } else{
            return INT_MAX;
        }
    }
    
    bool isSafe(int row, int col, int rowSize, int colSize){
        return row >= 0 && col >= 0 &&
               row < rowSize && col < colSize;
    }
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int rowSize = matrix.size(), colSize = matrix[0].size();
        int minFallingPathSumRes = INT_MAX;
        vector<vector<int>> memo(rowSize, vector<int>(colSize, INT_MAX));
        for(int col = 0; col < colSize; col++){
            minFallingPathSumRes = min(minFallingPathSumRes,
                                       solve(0, col, matrix, memo, rowSize, colSize));
        }
        return minFallingPathSumRes;
    }
};