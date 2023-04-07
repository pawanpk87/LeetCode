class Solution {
private:
    void dfs(int currRow,int currCol,vector<vector<int>>& grid,int n,int m){
        if(currRow>=0 && currCol>=0 && currRow<n && currCol<m){
            if(grid[currRow][currCol] == 1){
                grid[currRow][currCol] = -1;                
                dfs(currRow,currCol+1,grid,n,m);
                dfs(currRow,currCol-1,grid,n,m);
                dfs(currRow-1,currCol,grid,n,m);
                dfs(currRow+1,currCol,grid,n,m);
            }
        }   
    }    
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        dfs(i,j,grid,n,m);
                    }
                }
            }
        }
        
        int count = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        
        return count;
    }
};