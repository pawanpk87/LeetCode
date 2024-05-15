class MyCalendar {
    private List<Integer[]> list;

    public MyCalendar() {
        this.list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // printIntervals();
        
        int n = list.size();
        
        ArrayList<Integer[]> newList = new ArrayList<>();
        
        int index = 0;
        
        while(index < n && list.get(index)[0] < end){
            if(isOverlap(list.get(index)[0], list.get(index)[1], start, end)){
                return false;
            }
            newList.add(list.get(index++));
        }
        
        newList.add(new Integer[]{start, end});
        
        while(index < n){
            newList.add(list.get(index++));
        }
        
        this.list = newList;
        
        return true;
    }
    
    public boolean isOverlap(int x1, int y1, int x2, int y2){
        if(y1 <= x2 || y2 < x1){
            return false;
        } else{
            return true;
        }
    }
    
    public void printIntervals(){
        for(Integer[] interval : list){
            System.out.print(interval[0] + "-" + interval[1] + ",");
        }
        System.out.println();
    }
}