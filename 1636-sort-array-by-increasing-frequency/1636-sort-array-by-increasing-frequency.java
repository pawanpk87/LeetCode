class Num {
    public int num;
    public int freq;
    
    public Num(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        List<Num> numObjs = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> data : freq.entrySet()) {
            numObjs.add(new Num(data.getKey(), data.getValue()));
        }
        
        Collections.sort(numObjs, new Comparator<Num>() {
            @Override
            public int compare(Num num1, Num num2) {
                if(num1.freq < num2.freq) {
                    return -1;
                } else if(num1.freq > num2.freq) {
                    return 1;
                } else {
                    return num1.num < num2.num ? 1 : -1;
                }
            }
        });
        
        for(int i = 0, j = 0; i < numObjs.size(); i++) {
            int currNumFreq = numObjs.get(i).freq;
            while(currNumFreq-- > 0) {
                nums[j++] = numObjs.get(i).num;
            }
        }
        
        return nums;
    }
}