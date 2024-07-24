public class Pair {
    public int num;
    public int mapedValue;
    public int index;
    
    public Pair(int num, int mapedValue, int index) {
        this.num = num;
        this.mapedValue = mapedValue;
        this.index = index;
    }
    
    @Override
    public String toString() {
        return "Pair{" +
                "num=" + num +
                ", mapedValue=" + mapedValue +
                ", index=" + index +
                '}';
    }
}

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Pair> values = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            values.add(new Pair(nums[i], getMapedValue(nums[i], mapping), i));
        }
        
        Collections.sort(values, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.mapedValue < p2.mapedValue) {
                    return -1;
                } else if(p1.mapedValue > p2.mapedValue) {
                    return 1;
                } else {
                    return p1.index - p2.index;
                }
            }
        });
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = values.get(i).num;
        }
        
        return nums;
    }
    
    private int getMapedValue(int num, int[] mapping) {
        if(num >= 0 && num <= 9) {
            return mapping[num];
        }
        
        StringBuilder mapedValue = new StringBuilder();
        
        while(num > 0) {
            int digit = num % 10;
            mapedValue.append(mapping[digit]);
            num = num / 10;
        }
        
        return mapedValue.length() > 0 ? 
                Integer.valueOf(mapedValue.reverse().toString())
                        : 0;
    }
}