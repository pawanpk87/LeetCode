class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
        });
        
        for(int i = 0; i < n && i < k; i++) {
            minHeap.add(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k-- > 0) {
            int[] curr = minHeap.poll();
            
            res.add(Arrays.asList(curr[0], curr[1]));
            
            if(curr[2] == m-1) continue;
            
            minHeap.add(new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }
        
        return res;
    }
}