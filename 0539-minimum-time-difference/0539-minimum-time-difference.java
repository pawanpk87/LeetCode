class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        
        int[] minutes = new int[n];
        
        for(int i = 0; i < n; i++) {
            int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int m = Integer.parseInt(timePoints.get(i).substring(3));
            int totalMinutes = h * 60 + m;
            minutes[i] = totalMinutes;
        }
        
        Arrays.sort(minutes);
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, Math.abs(minutes[i-1] - minutes[i]));
        }
        
        return Math.min(minDiff, 24*60 - minutes[n-1] + minutes[0]);
    }
}