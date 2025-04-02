class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] maxNum = new int[n];

        maxNum[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            maxNum[i] = Math.max(maxNum[i + 1], nums[i]);
        }

        long res = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                long a, b, c;

                a = nums[i];
                b = nums[j];
                c = maxNum[j + 1];

                if(isValid(a, b, c)) {
                    res = Math.max(res, (a - b) * c);
                }
            }
        }

        return res;
    }

    private boolean isValid(long a, long b, long c) {
        return a >= 0 && b >= 0 && c >= 0;
    }
}