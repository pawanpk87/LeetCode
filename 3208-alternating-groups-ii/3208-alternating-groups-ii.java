class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int alternatigGroups = 0;
        int i = 0, j = 2;
        while(j < (n + k - 1)){
            int tempJ = j%n;
            int firstIndex = (n + tempJ - 2)%n;
            int secondIndex = (n + tempJ - 1)%n;
            int thirdIndex = tempJ;
            if(colors[firstIndex] != colors[secondIndex] && 
               colors[secondIndex] != colors[thirdIndex]){
                if((j - i + 1) == k){
                    alternatigGroups++;
                    i++;
                }
            } else {
                i = j - 1;
            }
            j++;
        }
        return alternatigGroups;
    }
}