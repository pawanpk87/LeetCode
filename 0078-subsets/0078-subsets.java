class Solution {
    private HashSet<List> subsets;
    
    private void solve(ArrayList<Integer> currSubset, int currIndex, int[] nums, int n){
        if(currIndex >= n){
            subsets.add(new ArrayList<>(currSubset));
            return;
        } 
        
        currSubset.add(nums[currIndex]);
        
        solve(currSubset, currIndex + 1, nums, n);
        
        currSubset.remove(currSubset.size() - 1);
        
        solve(currSubset, currIndex + 1, nums, n);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        subsets = new HashSet<>();
        solve(new ArrayList<>(), 0, nums, nums.length);
        return convertToList();
    }
    
    public void printSubsets() {
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
    
    public List<List<Integer>> convertToList() {
        List<List<Integer>> listOfSubsets = new ArrayList<>();
        for (List subset : subsets) {
            listOfSubsets.add(new ArrayList<>(subset));
        }
        return listOfSubsets;
    }
}