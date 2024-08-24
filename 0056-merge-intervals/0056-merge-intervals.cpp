class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int n = intervals.size();

        sort(intervals.begin(), intervals.end());

        vector<vector<int>> mergedIntervals;

        vector<int> prevInterval = intervals[0];
        
        for(int i = 1; i < n; i++){
            if(prevInterval[1] >= intervals[i][0]){
                prevInterval[1] = max(prevInterval[1], intervals[i][1]);
            }else{
                mergedIntervals.push_back(prevInterval);
                prevInterval = intervals[i];
            }
        }
        
        mergedIntervals.push_back(prevInterval);

        return mergedIntervals;
    }
};