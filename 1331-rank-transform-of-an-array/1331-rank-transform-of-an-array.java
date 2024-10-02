class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        
        if(n == 0) {
            return arr;
        }
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            list.add(new int[]{arr[i], i});
        }
        
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int[] ranks = new int[n];
        ranks[list.get(0)[1]] = 1;
        
        for(int i = 1; i < n; i++) {
            int index = list.get(i)[1];
            int prevIndex = list.get(i-1)[1];
            if(arr[index] == arr[prevIndex]) {
                ranks[index] = ranks[prevIndex];
            } else {
                ranks[index] = ranks[prevIndex] + 1;
            }
        }
        
        return ranks;
    }
}