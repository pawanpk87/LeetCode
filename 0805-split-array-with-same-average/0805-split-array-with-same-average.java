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
    
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        
        List<Integer>[] subsets1 = subsets(Arrays.copyOfRange(nums, 0, n/2 + 1));
        List<Integer>[] subsets2 = subsets(Arrays.copyOfRange(nums, n/2 + 1, n));
        
        for(int i = 0; i < subsets2.length; i++) {
            Collections.sort(subsets2[i]);
        }
        
        for(int i = 0; i < subsets1.length; i++) {
            for(int a : subsets1[i]) {
                for(int j = 0; j < subsets2.length; j++) {
                    if((i + j) == 0 || (i + j) == n) {
                        continue;
                    }
                    
                    /*
                        a/i == b/j
                     
                     ex:-
                        5/1 == 25/5
                          5 == 5
                        
                        
                        total = 30 
                        
                        b = 30 * 6 / n 
                          = 180 / 6 
                          = 30 - a 
                          = 30 - 5
                          = 25
                        
                    */
                
                    double b = (1.0 * total * (i + j)) / n - a;
                    
                    if(Math.ceil(b) != b) {
                        continue;
                    }
                    
                    if(Collections.binarySearch(subsets2[j], (int)b) >= 0) {
                        return true;
                    }
                }
            } 
        }
        
        return false;
    }
}



















