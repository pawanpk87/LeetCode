// Based on https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-ii/discuss/5687426/Simulation-and-visual-intuition-Explained-via-Pen-and-paper-Multiset-(Minheap)

/*
[161209470]
56851412
39846
*/

class Solution {
    public static int MOD = 1000000007;
    
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(multiplier == 1) {
            return nums;
        }
        
        int n = nums.length;
        
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(new Comparator<long[]>(){
            @Override
            public int compare(long[] a, long[] b) {
                if(a[0] == b[0]) {
                    return a[1] < b[1] ? -1 : 1; 
                }
                return a[0] < b[0] ? -1 : 1;
            }
        });
        
        int maxNumIndex = -1;
        for(int i = 0; i < n; i++) {
            if(maxNumIndex == -1 || nums[maxNumIndex] <= nums[i]) {
                maxNumIndex = i;
            }
            minHeap.add(new long[] {(long)nums[i], (long)i});
        }
        
        int operations = 0;
        while(operations < k) {
            long[] minNum = minHeap.poll();
            long prevNum = minNum[0], index = minNum[1];
            
            long newNum = prevNum * multiplier;
            minHeap.add(new long[] {newNum, index});
            
            operations++;
            
            if((int)index == maxNumIndex) {
                break;
            }
        }
        
        k = k - operations;
        
        int times = k/n;
        
        ArrayList<long[]> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            long[] minNum = minHeap.poll();
            long prevNum = minNum[0];
            int index = (int)minNum[1];
            
            long newNum = mutlti(prevNum, power(multiplier, times));
            
            result.add(new long[] {newNum, index});
        }
        
        if(k > 0) {
            for(int i = 0; i < (k%n); i++) {
                result.get(i)[0] = mutlti(result.get(i)[0], multiplier);
            }
        }
        
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[(int)result.get(i)[1]] = (int)(result.get(i)[0] % MOD);
        }
        
        return res;
    }
    
    private long mutlti(long num1, long num2) {
        num1 = num1 % MOD;
        num2 = num2 % MOD;
        return (num1 * num2) % MOD;
    }
    
    long power(long a, long b){
        if (b == 0) return 1;
        if ((b&1)==1) return mutlti(a, power(a, b - 1));
        return power(mutlti(a, a), b / 2);
    }
}