class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        int[][] friendsTimeing = new int[n][3];
        
        for(int i = 0; i < n; i++) {
            friendsTimeing[i][0] = times[i][0];
            friendsTimeing[i][1] = times[i][1];
            friendsTimeing[i][2] = i;
        }
        
        Arrays.sort(friendsTimeing, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               if(a[0] == b[0]) {
                   return a[1] - b[1];
               }
               return a[0] - b[0];
           } 
        });
        
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            availableChairs.add(i);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        int chair = -1;
        
        int startTime, endTime, f;
        
        for(int i = 0; i < n; i++) {
            startTime = friendsTimeing[i][0];
            endTime = friendsTimeing[i][1];
            f = friendsTimeing[i][2];
            
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= startTime) {
                availableChairs.add(minHeap.peek()[1]);
                minHeap.poll();
            }
            
            int assignedChair = availableChairs.poll();
                    
            if(f == targetFriend) {
                return assignedChair;
            }
            
            minHeap.add(new int[]{endTime, assignedChair});
        }
        
        return -1;
    }
}
/*
               1      2       0
    times = [[1,5], [2,6], [3,10]], targetFriend = 0
    
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17................
    | | |
    
    
    [[1,4],[2,3],[4,6]]
    
    
    {4 -> 0, 3 -> 1}
    
    
    minHeap 
        {
            leaveTime -> chair
        }
        
    
    if top of the leaveTime is smaller than current startTime
        then pop and take chair
    
    if not then chair count will be increamented

*/