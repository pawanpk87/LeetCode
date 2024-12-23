class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        
        int water = 0;
        int i = 0, j = n - 1;
        
        while(i < j) {
            int w = j - i;
            int h = Math.min(height[i], height[j]);
            
            water = Math.max(water, w * h);
            
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return water;
    }
}