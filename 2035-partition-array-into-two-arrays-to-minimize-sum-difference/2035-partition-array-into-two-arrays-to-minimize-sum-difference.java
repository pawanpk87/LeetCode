class Solution {
    private List<Integer>[] subsets(int[] nums) {
        int n = nums.length;
        
        List<Integer>[] allSizeSubset = new List[n + 1];
        
        for(int i = 0; i <= n; i++) {
            allSizeSubset[i] = new ArrayList<>();
        }
        
        for(int k = 0; k < Math.pow(2, n); k++) {
            int size = 0;
            int sum = 0;
            
            for(int i = 0; i < n; i++) {
                if(((1 << i) & k) != 0) {
                    size++;
                    sum += nums[i];
                }
            }
            
            allSizeSubset[size].add(sum);
        }
        
        return allSizeSubset;
    }
    
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        
        int total = 0;
        
        for(int num : nums) {
            total += num;
        }
        
        List<Integer>[] subsets1 = subsets(Arrays.copyOfRange(nums, 0, n/2));
        List<Integer>[] subsets2 = subsets(Arrays.copyOfRange(nums, n/2, n));
        
        for(int i = 0; i < subsets2.length; i++) {
            Collections.sort(subsets2[i]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < subsets1.length; i++) {
            for(int a : subsets1[i]) {
                int j = n/2 - i;
                int rem = total/2 - a;
                
                int index = Collections.binarySearch(subsets2[j], rem);
                
                if(index < 0) {
                    index = -(index + 1);
                }
                
                if(index < subsets2[j].size()) {
                    minDiff = Math.min(minDiff, Math.abs(total - 2*a - 2*subsets2[j].get(index)));
                }
                
                if(index > 0) {
                    minDiff = Math.min(minDiff, Math.abs(total - 2*a - 2*subsets2[j].get(index - 1)));
                }
            }
        }
    
        return minDiff;
    }
}
/*
    [3,9,7,3]
    
    [3, 9] 
     0 -> 0
     1 -> 3, 9
     2 -> 12
     
    [7, 3] 
     0 -> 0
     1 -> 7, 3
     2 -> 10
     
     total = 22
     a - b = x
     x should be as small as possible
     
     j = n/2 - i
     rem = total/2 - a
     
     
     Since the total sum is fixed (Tsum), 
     the sum of the elements in both parts must add up to Tsum. 
     
     Therefore: If one part has a sum a, the other part would have a 
     sum Tsum - a. 
     
     So, instead of calculating |a - b|, we can look at it as: 
     Difference = ∣ Tsum − 2*a ∣
     
     
     2*a - 2 * 
*/