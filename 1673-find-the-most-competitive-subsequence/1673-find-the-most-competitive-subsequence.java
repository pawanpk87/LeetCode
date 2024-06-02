class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        
        k = n - k;
        
        ArrayList<Integer> currNum = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            while(currNum.isEmpty() == false && 
                    currNum.get(currNum.size() - 1) > nums[i] && 
                        k > 0){
                currNum.remove(currNum.size() - 1);
                k--;
            }
            currNum.add(nums[i]);
        }
        
        while(k > 0 && currNum.isEmpty() == false){
            currNum.remove(currNum.size() - 1);
            k--;
        }
        
        int[] ans = new int[currNum.size()];
        for(int i = 0; i < currNum.size(); i++){
            ans[i] = currNum.get(i);
        }
        
        return ans;
    }
}
/*
    [71,18,52,29,55,73,24,42,66,8,80,2]     3
    
    
    
    
    
    
    


*/