class Solution {
    public int maxPathLength(int[][] coordinates, int k) {
        int targetX = coordinates[k][0];
        int targetY = coordinates[k][1];
        
        Arrays.sort(coordinates, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               if(a[0] == b[0]) {
                   return b[1] - a[1];
               }
               return a[0] - b[0];
           } 
        });
        
        List<Integer> leftCoordinates = new ArrayList<>();
        List<Integer> rightCoordinates = new ArrayList<>();
        
        
        int x,y;
        for(int[] coordinate : coordinates) {
            x = coordinate[0]; y = coordinate[1];
            
            if(targetX > x && targetY > y) {
                leftCoordinates.add(y);
            }
            
            if(targetX < x && targetY < y) {
                rightCoordinates.add(y);
            }
        }
        
        return LIC(leftCoordinates) + LIC(rightCoordinates) + 1;
    }
    
    private int LIC(List<Integer> list) {
        int n = list.size();
        int[] dp = new int[n];
        int size = 0;
        for(int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(dp, 0, size, list.get(i));
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = list.get(i);
            if(index == size) {
                size++;
            }
        }
        return size;
    }
}