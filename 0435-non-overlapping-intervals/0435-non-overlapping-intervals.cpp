class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());        
        int count=0;        
        auto it=intervals[0];
        for(int i=1; i<intervals.size(); i++)
        {
            if(it[1]>intervals[i][0])
            {
                it[1]=min(it[1],intervals[i][1]);
                count++;
            }
            else
            {
                it=intervals[i];
            }
        }
        return count;
    }
};