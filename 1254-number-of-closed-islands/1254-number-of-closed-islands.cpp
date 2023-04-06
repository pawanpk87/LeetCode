int dx[4] = {0,1,0,-1};
int dy[4] = {-1,0,1,0};

class Solution {
private:
    bool dfs(int i,int j,vector<vector<int>>& grid,int n,int m){
        if(i>=0 && j>=0 && i<n && j<m){
            if(grid[i][j] == 1 || grid[i][j] == -1){
                return true;
            }
            
            grid[i][j] = -1;
            
            bool isClosed = true;
            
            for(int k=0; k<4; k++){
                int newI = i+dx[k];
                int newJ = j+dy[k];
                if(!dfs(newI,newJ,grid,n,m)){
                    isClosed = false;
                }
            }
            
            return isClosed;            
        }else{
            return false;
        }
    }
public:
    int closedIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int count = 0;
        for(int i = 1; i<n; i++){
            for(int j=1; j<m; j++){
                if(grid[i][j] == 0 && dfs(i,j,grid,n,m)){
                    count++;
                }
            }
        }
        return count;
    }
};