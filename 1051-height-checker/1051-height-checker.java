class Solution {
    public int heightChecker(int[] heights) {
        int[] expectedHeight = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expectedHeight);
        int count = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != expectedHeight[i]){
                count++;
            }
        }
        return count;
    }
}