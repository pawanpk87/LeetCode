class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        if(points.size() == 0)
            return 0;
        sort(points.begin(),points.end());
        int count=1;
        auto it=points[0];
        for(int i=1; i<points.size(); i++)
        {
            if(it[1]>=points[i][0])
            {
                it[1]=min(it[1],points[i][1]);                
            }
            else
            {
                count++;
                it=points[i];                
            }
        }
        return count;
    }
};