class Solution {
public:
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        int mod = 12345;
        
        vector<vector<int>> multi1(n, vector<int>(m));
        vector<vector<int>> multi2(n, vector<int>(m));
        vector<vector<int>> ans(n, vector<int>(m));
        
        long long prod = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                multi1[i][j] = prod;
                prod *= grid[i][j];
                prod %= mod;
            }
        }
        
        prod = 1;
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                multi2[i][j] = prod;
                prod *= grid[i][j];
                prod %= mod;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = (multi1[i][j] * multi2[i][j]) % mod;
            }
        }
        
        return ans;
    }
};