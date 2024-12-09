class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        
        ArrayList<int[]> res = new ArrayList<>();
        
        int index = 0;
        
        while(index < n && intervals[index][1] < newInterval[0]) {
            res.add(intervals[index]);
            index++;
        }
        
        while(index < n && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        
        res.add(newInterval);
        
        while(index < n) {
            res.add(intervals[index]);
            index++;
        }
        
        int[][] mergedIntervals = new int[res.size()][2];
        
        for(int i = 0; i < res.size(); i++) {
            mergedIntervals[i] = res.get(i);
        }
        
        return mergedIntervals;
    }
}