class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        
        vector<vector<int>> minSum(n,vector<int>(m,0));
        
        for(int i=0; i<n; i++)
        {
            if(i == 0)
                minSum[i][0]=grid[i][0];
            else
                minSum[i][0]=minSum[i-1][0]+grid[i][0];
        }
        
        for(int j=0; j<m; j++)
        {
            if(j == 0)
                minSum[0][j]=grid[0][j];
            else
                minSum[0][j]=minSum[0][j-1]+grid[0][j];
        }
        
        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                minSum[i][j]=grid[i][j] + min(minSum[i-1][j],minSum[i][j-1]); 
            }
        }
        
        return minSum[n-1][m-1];
    }
};