class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int index = 0;

        while(index < n) {
            if(freq.size() != (n - index)) {
                removeElement(freq, nums[index++]);

                if(index < n)
                    removeElement(freq, nums[index++]);

                if(index < n)
                    removeElement(freq, nums[index++]);
                    
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    private void removeElement(Map<Integer, Integer> freq, int num) {
        freq.put(num, freq.get(num) - 1);
        if(freq.get(num) == 0) {
            freq.remove(num);
        }
    }
}