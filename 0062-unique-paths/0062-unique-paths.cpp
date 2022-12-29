class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> grid(m,vector<int>(n,1));
        
        for(int row=1; row<m; row++)
        {
            for(int col=1; col<n; col++)
            {
                grid[row][col]=grid[row-1][col]+grid[row][col-1];
            }
        }

        return grid[m-1][n-1];
    }
};
