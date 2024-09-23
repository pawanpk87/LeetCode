class Solution {
    private boolean wordBreakUtil(String s, Set<String> wordDict, Map<String, Boolean> memo) {
        int n = s.length();
        
        if(n == 0) {
            return true;
        }
        
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        
        boolean result = false;
        
        for(int i = 0; i < n; i++) {
            if(wordDict.contains(s.substring(0, i + 1)) &&
               wordBreakUtil(s.substring(i+1), wordDict, memo)) {
                result = true;
                break;
            }
        }
        
        memo.put(s, result);
        
        return result;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakUtil(s, st, memo);
    }
}