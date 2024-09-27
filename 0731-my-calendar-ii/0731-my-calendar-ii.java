class MyCalendarTwo {
    TreeMap<Integer, Integer> mp;
    
    public MyCalendarTwo() {
        mp = new TreeMap<>();        
    }
    
    public boolean book(int start, int end) {
        mp.put(start, mp.getOrDefault(start, 0) + 1);
        mp.put(end, mp.getOrDefault(end, 0) - 1);
        
        int count = 0;
        
        for(Map.Entry<Integer, Integer> data : mp.entrySet()) {
            count += data.getValue();
            if(count > 2) {
                mp.put(start, mp.get(start) - 1);
                if(mp.get(start) == 0) {
                    mp.remove(start);
                }
                
                mp.put(end, mp.get(end) + 1);
                if(mp.get(end) == 0) {
                    mp.remove(end);
                }
                return false;
            }
        }
        
        return true;
    }
}