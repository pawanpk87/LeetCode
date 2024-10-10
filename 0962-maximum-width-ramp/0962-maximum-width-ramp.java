class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        
        Integer[] indx = new Integer[n];
        for(int i = 0; i < n; i++) {
            indx[i] = i;
        }
        
        Arrays.sort(indx, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                if(nums[a] == nums[b]) {
                    return a - b;
                }
                return nums[a] - nums[b];
            }
        });
        
        int maxWidth = 0;
        int minI = n;
        
        for(int idx : indx) {
            maxWidth = Math.max(maxWidth, idx - minI);
            minI = Math.min(minI, idx);
        }
        
        return maxWidth;
    }
}