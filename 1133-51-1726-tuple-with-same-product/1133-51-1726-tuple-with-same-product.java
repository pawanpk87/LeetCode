class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;

        Map<Long, Integer> prodFreq = new HashMap<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                long prod = nums[i] * nums[j];
                prodFreq.put(prod, prodFreq.getOrDefault(prod, 0) + 1);
            }
        }

        int count = 0;

        for(int prodF : prodFreq.values()) {
            int pairsOfEqualProd = ((prodF - 1) * prodF) / 2;
            count = count + 8 * pairsOfEqualProd;
        }

        return count;
    }
}