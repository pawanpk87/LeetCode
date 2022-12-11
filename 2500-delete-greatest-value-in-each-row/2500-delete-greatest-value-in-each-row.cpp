class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {        
        for(int i=0; i<grid.size(); i++)
        {
            sort(grid[i].begin(),grid[i].end());
        }
        
        int sum=0;
        
        for(int k=grid[0].size()-1; k>=0; k--)
        {
            int maxValue=0;
            for(int i=0; i<grid.size(); i++)
            {
                maxValue=max(maxValue,grid[i][k]);
            }
            sum+=maxValue;            
        }
        
        return sum;
    }
};