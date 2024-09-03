class Solution {
    private Map<String, Integer> cache;
    
    private int solve(int currIndex, int rowMask, List<int[]> list) {
        int n = list.size();
        
        if(currIndex == n) {
            return 0;
        }
        
        String key = currIndex + "." + rowMask;
        
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int ans = 0;
        
        int numRow = list.get(currIndex)[1];
        
        if((rowMask & (1 << numRow)) > 0) {
            ans = solve(currIndex + 1, rowMask, list);
        } else {
            int nextIndex = currIndex;
            while(nextIndex < n && list.get(nextIndex)[0] == list.get(currIndex)[0]) {
                nextIndex++;
            }

            int pos1 = list.get(currIndex)[0] + solve(nextIndex, (rowMask | (1 << numRow)), list);
            int pos2 = solve(currIndex + 1, rowMask, list);

            ans = Math.max(pos1, pos2);
        }
        
        cache.put(key, ans);
        
        return ans;
    }
    
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                list.add(new int[]{grid.get(i).get(j), i});
            }
        }
        
        Collections.sort(list, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        
        cache = new HashMap<>();
        
        return solve(0, 0, list);
    }
}