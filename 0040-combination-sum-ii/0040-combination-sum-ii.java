class Solution {
    private Set<List<Integer>> resList;
    
    private void solve(int index, List<Integer> currCandidates, int[] candidates, int target) {
        if(target == 0) {
            resList.add(new ArrayList<>(currCandidates));
            return;
        }
        
        if(index == candidates.length) {
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            } 
            
            if(candidates[i] <= target) {
                currCandidates.add(candidates[i]);
                solve(i + 1, currCandidates, candidates, target - candidates[i]);
                currCandidates.remove(currCandidates.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        resList = new HashSet<>();
        
        List<Integer> currCandidates = new ArrayList<>();
        
        solve(0, currCandidates, candidates, target);
        
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> list : resList) {
            res.add(list);
        }
        
        return res;
    }
}
/*
        
    1 2 2 2 5
    
    
        
        




*/