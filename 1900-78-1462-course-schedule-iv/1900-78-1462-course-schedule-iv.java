class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        int u, v;
        for(int[] edge : prerequisites) {
            u = edge[0]; v = edge[1];
            isPrerequisite[u][v] = true;
        }

        for(int intermediate = 0; intermediate < numCourses; intermediate++) {
            for(int src = 0; src < numCourses; src++) {
                for(int dest = 0; dest < numCourses; dest++) {
                    isPrerequisite[src][dest] = isPrerequisite[src][dest] ||
                        (isPrerequisite[src][intermediate] && isPrerequisite[intermediate][dest]);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();

        for(int[] query : queries) {
            res.add(isPrerequisite[query[0]][query[1]]);
        }

        return res;
    }
}