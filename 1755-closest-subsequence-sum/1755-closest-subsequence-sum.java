class Solution {
    private List<Integer> subsets(int[] nums) {
        int n = nums.length;
        
        List<Integer> allSubset = new ArrayList<>();
        
        for(int k = 0; k < Math.pow(2, n); k++) {
            int sum = 0;
        
            for(int i = 0; i < n; i++) {
                if(((1 << i) & k) != 0) {
                    sum += nums[i];
                }
            }
            
            allSubset.add(sum);
        }
        
        return allSubset;
    }
    
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        
        int nn = (n + 1) / 2;
        
        int[] nums1 = new int[nn];
        int[] nums2 = new int[nn];
        
        for(int i = 0; i < n; i++) {
            if(i < nn) {
                nums1[i] = nums[i];
            } else {
                nums2[i%nn] = nums[i];
            }
        }
        
        List<Integer> subsets1 = subsets(nums1);
        List<Integer> subsets2 = subsets(nums2);
        
        Collections.sort(subsets2);
        
        int minValue = Integer.MAX_VALUE;
        
        for(int sub1 : subsets1) {
            int k = goal - sub1;
            
            int index = Collections.binarySearch(subsets2, k);
            
            if(index >= 0) {
                return 0;
            }
            
            index = -(index + 1);
            
            if(index < subsets2.size()) {
                minValue = Math.min(minValue, Math.abs(k - subsets2.get(index)));
            }
            
            if(index > 0) {
                minValue = Math.min(minValue, Math.abs(k - subsets2.get(index - 1)));
            }
        }
        
        return minValue;
    }
}
/*
    
    [5,-7,3,5]
    
    
    [5, -7] -> 0, 5, -7, 2
    
    [3, 5] -> 0, 3, 5, 8
    
    
    sum - goal = 0
    
    (sb1 + sb2) - goal = 0
    
    (sb1 + ? ) - goal = 0
    
    x1, x2, x3 ...... xn 
    
        (x1 + ?) - goal = 0
        
        x1 - goal = y
            |
            
          find sb2 smaller than y 
            sb2 >= y
            

*/