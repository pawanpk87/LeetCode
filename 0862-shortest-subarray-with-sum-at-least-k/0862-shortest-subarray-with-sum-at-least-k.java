class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        
        PriorityQueue<long[]> prefixSum = new PriorityQueue<long[]>(new Comparator<long[]>(){
            public int compare(long[] a, long[] b) {
                if(a[0] == b[0]) {
                    return (int) (a[1] - b[1]);
                }
                return (int) (a[0] - b[0]);
            }
        });
        
        int len = Integer.MAX_VALUE;
        
        int i = 0;
        long sum = 0;
        
        while(i < n) {
            sum += nums[i];
            
            if(sum >= k) {
                len = Math.min(len, i + 1);
            }
            
            while(!prefixSum.isEmpty() &&
                  (sum - prefixSum.peek()[0]) >= k) {
                len = Math.min(len, (int) (i - prefixSum.poll()[1]));
            }
            
            prefixSum.add(new long[] {sum, i});
            
            i++;
        }
        
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}