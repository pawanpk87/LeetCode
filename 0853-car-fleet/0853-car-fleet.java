class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        List<int[]> cars = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            cars.add(new int[]{position[i], speed[i]});
        }
        
        Collections.sort(cars, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        Stack<Double> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            Double timeToReach = (double)(target - cars.get(i)[0]) / (double)cars.get(i)[1];
            while(!st.isEmpty() && timeToReach >= st.peek()) {
                st.pop();
            }
            st.push(timeToReach);
        }
        
        return st.size();
    }
}