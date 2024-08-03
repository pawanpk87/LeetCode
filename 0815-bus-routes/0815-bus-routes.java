class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> stationBus = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++) {
            for(int station : routes[i]) {
                stationBus.putIfAbsent(station, new ArrayList<>());
                stationBus.get(station).add(i);
            }
        }
        
        
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        
        q.add(new int[] {source, 0});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            int currStation = curr[0];
            int currBusTaken = curr[1];
            
            if(currStation == target) {
                return currBusTaken;
            }
            
            if(stationBus.containsKey(currStation)) {
                for(int bus : stationBus.get(currStation)) {
                    if(!visitedBuses.contains(bus)) {
                        for(int nextStation : routes[bus]) {
                            q.add(new int[] {nextStation, currBusTaken + 1});
                        }
                        visitedBuses.add(bus);
                    }
                }
            }
        }
        
        return -1;
    }
}