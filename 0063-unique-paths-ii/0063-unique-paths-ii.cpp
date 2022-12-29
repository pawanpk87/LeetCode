class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int n=obstacleGrid.size();
        int m=obstacleGrid[0].size();

        if(obstacleGrid[n-1][m-1] == 1)
            return 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j]=-1;
            }
        }

        for(int i=0; i<n; i++)
        {
            if(obstacleGrid[i][0] == -1)
                break;
            else
                obstacleGrid[i][0]=1;
        }

        for(int j=0; j<m; j++)
        {
            if(obstacleGrid[0][j] == -1)
                break;
            else
                obstacleGrid[0][j]=1;
        }

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(obstacleGrid[i][j] == 0)
                {
                    int op1=obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j];
                    int op2=obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1];
                    obstacleGrid[i][j]=op1+op2;
                }
            }
        }

        return obstacleGrid[n-1][m-1];
    }
};

