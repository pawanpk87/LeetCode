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
    
    int countDays(int days, vector<vector<int>>& meetings) {
        vector<vector<int>> mergedIntervals = merge(meetings);
        //printIntervals(mergedIntervals);
        int countDays = 0;
        int lastDay = 0;
        for(auto& interval : mergedIntervals){
            if(interval[0] <= days && lastDay < interval[0]){
                countDays += ((interval[0] - lastDay) - 1);
            }
            if(interval[0] > days){
                break;
            }
            lastDay = interval[1];
        }
        if(lastDay < days){
            countDays += days - lastDay;
        }
        return countDays;
    }
    
    void printIntervals(vector<vector<int>>& intervals){
        for(auto& interval : intervals){
            cout<<interval[0]<<" "<<interval[1]<<endl;
        }
    }
};