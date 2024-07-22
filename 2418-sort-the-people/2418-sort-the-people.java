class People implements Comparable<People>{
    public String name;
    public Integer height;
    
    public People(String name, Integer height) {
        this.name = name;
        this.height = height;
    }
    
    @Override
    public int compareTo(People p) {
        if(this.height > p.height) {
            return -1;
        } else if(this.height < p.height) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<People> peoples = new ArrayList<>();  
        for(int i = 0; i < heights.length; i++) {
            peoples.add(new People(names[i], heights[i]));
        }
        Collections.sort(peoples);
        for(int i = 0; i < names.length; i++) {
            names[i] = peoples.get(i).name;
        }
        return names;
    }
}