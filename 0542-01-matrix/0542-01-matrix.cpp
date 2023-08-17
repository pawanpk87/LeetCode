class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        
        queue<pair<int,int>> bfs;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    bfs.push({i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int dx[4] = {0, 0, -1, 1};
        int dy[4] = {-1, 1, 0, 0};
        
        while(!bfs.empty()){
            int i = bfs.front().first;
            int j = bfs.front().second;
            
            bfs.pop();
            
            for(int k=0; k<4; k++){
                int nextI = i + dx[k];
                int nextJ = j + dy[k];
                
                if(nextI>=0 && nextJ>=0 && nextI<n && nextJ<m &&
                   mat[nextI][nextJ] == -1){
                    mat[nextI][nextJ] = mat[i][j] + 1;
                    
                    bfs.push({nextI,nextJ});
                }
            }
        }
        
        return mat;        
    }
};