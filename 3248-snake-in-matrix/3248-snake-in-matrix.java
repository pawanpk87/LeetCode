class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for(String command : commands) {
            if("RIGHT".equals(command)) {
                j++;
            } else if("DOWN".equals(command)) {
                i++;
            } else if("LEFT".equals(command)) {
                j--;
            } else {
                i--;
            }
        }
        return (i*n) + j;
    }
}