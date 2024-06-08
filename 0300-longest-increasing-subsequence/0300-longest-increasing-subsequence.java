class Solution {
    private int getLowerBound(List<Integer> increasingSubsequence, int target){
        int left = 0, right = increasingSubsequence.size()-1;
        while(left != right){
            int mid = (left + right)/2;
            if(increasingSubsequence.get(mid) < target){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }
    
    public int lengthOfLIS(int[] nums) {
        List<Integer> increasingSubsequence = new ArrayList<>();
        for(int num : nums){
            if(increasingSubsequence.size() == 0 || 
               increasingSubsequence.get(increasingSubsequence.size() - 1) < num){
                increasingSubsequence.add(num);
            } else {
                int lower_bound_index = getLowerBound(increasingSubsequence, num);
                increasingSubsequence.set(lower_bound_index, num); 
            }
        }
        return increasingSubsequence.size();
    }
}