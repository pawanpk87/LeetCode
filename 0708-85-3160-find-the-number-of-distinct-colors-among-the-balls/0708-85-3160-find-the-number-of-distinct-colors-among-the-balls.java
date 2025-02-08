class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;

        int[] res = new int[n];

        Map<Integer, Integer> indexNumMap = new HashMap<>();
        Map<Integer, Integer> numFreqMap = new HashMap<>();

        int index, value;
        for(int i = 0; i < n; i++) {
            index = queries[i][0]; value = queries[i][1];

            if(indexNumMap.containsKey(index)) {
                int prevNum = indexNumMap.get(index);

                numFreqMap.put(prevNum, numFreqMap.get(prevNum) - 1);

                if(numFreqMap.get(prevNum) == 0) {
                    numFreqMap.remove(prevNum);
                } 
            }

            indexNumMap.put(index, value);
            numFreqMap.put(value, numFreqMap.getOrDefault(value, 0) + 1);

            res[i] = numFreqMap.size();
        }

        return res;
    }
}