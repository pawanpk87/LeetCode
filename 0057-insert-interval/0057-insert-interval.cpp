class Solution {
private:
    vector<vector<int>> mergeIntervals(vector<vector<int>>& intervals)
    {
        vector<vector<int>> res;
        
        auto& currInterval=intervals[0];
        
        for(auto& interval : intervals)
        {
            if(currInterval[1] >= interval[0])
            {
               currInterval[1]=max(currInterval[1],interval[1]); 
            }
            else
            {
                res.push_back(currInterval);
                currInterval=interval;
            }
        }
        
        res.push_back(currInterval);
        
        return res;
    }
    
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        
        if(intervals.size() == 0)
            return {newInterval};
             
        if(newInterval.size() == 0)
            return intervals;
        
        vector<vector<int>> res;
        
        for(auto& interval : intervals)
        {
            if(newInterval.size() != 0 && interval[0] > newInterval[0])
            {
                res.push_back(newInterval);
                res.push_back(interval);
                newInterval={};
            }
            else
            {
                res.push_back(interval); 
            }            
        }
        
        if(newInterval.size() != 0)
            res.push_back(newInterval);
        
        return mergeIntervals(res);
    }
};