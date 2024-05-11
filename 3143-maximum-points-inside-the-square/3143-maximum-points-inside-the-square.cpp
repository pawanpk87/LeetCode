class Solution {
public:
    int maxPointsInsideSquare(vector<vector<int>>& points, string s) {
        int n = points.size();
        
        vector<int> strip;
        for(auto& point : points){
            int limit = max(abs(point[0]), abs(point[1]));
            strip.push_back(limit);
        }
        
        unordered_map<char, int> maxRange;
        int finalRange = INT_MAX;
        
        for(int i = 0; i < n; i++){
            int currMaxRange = strip[i];
            if(maxRange.count(s[i])){
                if(currMaxRange < maxRange[s[i]]){
                    swap(maxRange[s[i]], currMaxRange);
                }
                finalRange = min(finalRange, currMaxRange);
            } else{
                maxRange[s[i]] = currMaxRange;
            }
        }
        
        int count = 0;
        for(auto& limit : strip){
            if(limit < finalRange){
                count++;
            }
        }
        
        return count;
    }
};