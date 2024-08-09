class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] 
                                                        ? Integer.compare(nums[a], nums[b]) 
                                                            : a - b;
        
        TreeSet<Integer> small = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> large = new TreeSet<>(comparator);
        
        Supplier<Double> median = (k % 2 == 0) 
                                    ? () -> ((double) nums[small.first()] + nums[large.first()]) / 2
                                    : () -> (double) nums[large.first()];
        
        Runnable balance = () -> { 
            while(large.size() < small.size()) { 
                large.add(small.pollFirst()); 
            } 
        };
        
        double[] result = new double[(n - k + 1)];
        
        for(int i = 0; i < k; i++) {
            small.add(i);
        }
        
        balance.run();
        result[0] = median.get();
        
        for(int i = k, index = 1; i < n; i++, index++) {
            if(!small.remove(i-k)) {
                large.remove(i-k);
            }
            
            large.add(i);
            small.add(large.pollFirst());
            
            balance.run();
            result[index] = median.get();
        }
        
        return result;
    }
}