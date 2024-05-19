class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int dist = 0;
        for(int j = 0; j < 32; j++){
            int ones = 0;
            for(int i = 0; i < n; i++){
                if(((nums[i] >> j)&1) == 1){
                    ones++;
                }
            }
            dist += ones * (n - ones);
        }
        return dist;
    }
}