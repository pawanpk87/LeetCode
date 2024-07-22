class People{
    public String name;
    public Integer height;
    
    public People(String name, Integer height) {
        this.name = name;
        this.height = height;
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<People> peoples = new ArrayList<>();  
        
        for(int i = 0; i < heights.length; i++) {
            peoples.add(new People(names[i], heights[i]));
        }
        
        Comparator<People> nameComparator = new Comparator<People>() {
            @Override
            public int compare(People p1, People p2) {
                if(p1.height > p2.height) {
                    return -1;
                } else if(p1.height < p2.height) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        
        Collections.sort(peoples, nameComparator);
        
        for(int i = 0; i < names.length; i++) {
            names[i] = peoples.get(i).name;
        }
        
        return names;
    }
}