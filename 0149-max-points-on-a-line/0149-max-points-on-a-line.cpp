class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int n = points.size();
        int maxCount = 0;
        for(int i=0; i<n; i++)
        {
            unordered_map<double,int> mp;
            
            int samePoint = 1;
            
            for(int j=i+1; j<n; j++)
            {
                int x1 = points[i][0], x2 = points[j][0];
                int y1 = points[i][1], y2 = points[j][1];
                
                if(x1 == x2 && y1 == y2)
                    samePoint++;
                else if(x1 == x2)
                    mp[LONG_MAX]++;
                else
                {
                    double slop = (double) (y1 - y2) / (double) (x1 - x2);
                    mp[slop]++;
                }
            }
            
            int currMaxCount=0;
            
            for(auto& data : mp)
            {
                currMaxCount = max(currMaxCount,data.second);
            }
            
            currMaxCount += samePoint;
            
            maxCount = max(maxCount,currMaxCount);
        }
        
        return maxCount;
    }
};