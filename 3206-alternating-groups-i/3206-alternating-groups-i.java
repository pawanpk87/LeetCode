class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int alternatingGroups = 0;
        for(int i = 0; i < n; i++){
            if(isAlternatingGroups(colors[i], colors[(i + 1)%n], colors[(i + 2)%n])){
                alternatingGroups++;
            }
        }
        return alternatingGroups;
    }
    
    private boolean isAlternatingGroups(int color1, int color2, int color3){
        return color1 == color3 && color1 != color2 && color3 != color2;
    }
}