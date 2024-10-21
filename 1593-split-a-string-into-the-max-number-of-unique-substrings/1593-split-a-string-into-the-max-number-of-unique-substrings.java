class Solution {
    private int maxUniqueSplitUtil(int currIndex, String str, Set<String> seen) {
        int n = str.length();
        
        if(currIndex >= n) {
            return 0;
        }    
        
        int maxCount = 0;
        
        for(int i = currIndex; i < n; i++) {
            String currSubStr = str.substring(currIndex, i + 1);
            
            if(seen.contains(currSubStr) == false) {
                seen.add(currSubStr);
                maxCount = Math.max(maxCount, 1 + maxUniqueSplitUtil(i + 1, str, seen));
                seen.remove(currSubStr);
            }
        }
        
        return maxCount;
    }
    
    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        
        return maxUniqueSplitUtil(0, s, seen);
    }
}