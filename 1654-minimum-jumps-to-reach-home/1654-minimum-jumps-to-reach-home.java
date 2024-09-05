class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSt = new HashSet<>();
        for (int f : forbidden) {
            forbiddenSt.add(f);
        }

        Queue<Pair<Integer, Boolean>> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[2][6000];

        bfs.add(new Pair<>(0, false));
        visited[0][0] = true;
        visited[1][0] = true;

        int jumps = 0;

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            while (size-- > 0) {
                Pair<Integer, Boolean> currNode = bfs.poll();

                int cur = currNode.getKey();
                boolean flag = currNode.getValue();

                if (cur == x) {
                    return jumps;
                }

                int forwardPos = cur + a;
                int backwardPos = cur - b;

                if (forwardPos < 6000 
                    && !visited[0][forwardPos] 
                    && !forbiddenSt.contains(forwardPos)) {
                    bfs.add(new Pair<>(forwardPos, false));
                    visited[0][forwardPos] = true;
                }

                if (backwardPos >= 0 
                    && !visited[1][backwardPos] 
                    && !forbiddenSt.contains(backwardPos) 
                    && !flag) {
                    bfs.add(new Pair<>(backwardPos, true));
                    visited[1][backwardPos] = true;
                }
            }
            jumps++;
        }

        return -1;
    }
}