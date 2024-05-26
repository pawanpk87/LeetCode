class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        unordered_map<int, set<int>> colors;
        unordered_map<int, int> balls;
        vector<int> res;
        int x,y;
        for(auto& querie : queries){
            x = querie[0];
            y = querie[1];
            
            if(balls.find(x) == balls.end()){
                colors[y].insert(x);
                balls[x] = y;
            } else{
                int prevColor = balls[x];
                colors[prevColor].erase(x);
                if(colors[prevColor].size() == 0){
                    colors.erase(prevColor);
                }
                colors[y].insert(x);
                balls[x] = y;
            }
            res.push_back(colors.size());
        }
        return res;
    }
};