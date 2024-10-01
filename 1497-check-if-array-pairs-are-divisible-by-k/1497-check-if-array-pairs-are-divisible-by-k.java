class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
    
        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }

        for (int num : arr) {
            int rem = ((num % k) + k) % k;

            if (rem == 0) {
                if(mp.get(rem)%2 != 0) {
                    return false;
                }
            }
            else if (!Objects.equals(mp.get(rem), mp.get(k - rem))) {
                return false;
            }
        }

        return true;
    }
}