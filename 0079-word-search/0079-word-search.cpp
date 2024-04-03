class Solution {
private:
    bool dfs(int currRow, 
             int currCol, 
             int currIndex, 
             vector<vector<char>>& board, 
             string& word, int row, 
             int col, 
             int n){
        if(currRow >= 0 && currCol >= 0 && 
           currRow < row && currCol < col && 
           board[currRow][currCol] == word[currIndex]){
            
            if(currIndex == n-1){
                return true;
            }
            
            board[currRow][currCol] = '#';
            
            bool r = dfs(currRow, currCol+1, currIndex+1, board, word, row, col, n);
            bool l = dfs(currRow, currCol-1, currIndex+1, board, word, row, col, n);
            bool b = dfs(currRow+1, currCol, currIndex+1, board, word, row, col, n);
            bool u = dfs(currRow-1, currCol, currIndex+1, board, word, row, col, n);
            
            board[currRow][currCol] = word[currIndex];
            
            return r || l || b || u;
        } else{
            return false;
        }
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        int row = board.size(), col = board[0].size();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == word[0]){
                    if(dfs(r, c, 0, board, word, row, col, word.size())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
};