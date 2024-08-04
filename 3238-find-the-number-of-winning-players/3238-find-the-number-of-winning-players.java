class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int[] x : pick) {
            int p = x[0];
            int c = x[1];
            mp.putIfAbsent(p, new ArrayList<>(Collections.nCopies(11, 0)));
            mp.get(p).set(c, mp.get(p).get(c) + 1);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (mp.containsKey(i)) { 
                for (int c : mp.get(i)) {
                    if (c > i) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}