class Solution {
    public int minGroups(int[][] intervals) {
        Map<Integer, Integer> mp = new TreeMap<>();
        
        int start, end;
        for(int[] interval : intervals) {
            start = interval[0]; end = interval[1];
            mp.put(start, mp.getOrDefault(start, 0) + 1);
            mp.put(end + 1, mp.getOrDefault(end + 1, 0) - 1);
        }
        
        int maxGroup = 0;
        int currGroup = 0;
        
        for(int p : mp.values()) {
            currGroup += p;
            maxGroup = Math.max(maxGroup, currGroup);
        }
        
        return maxGroup;
    }
}