class Solution {
    private void merge(int[] nums, int start, int mid, int end) {
        List<Integer> sortedArr = new ArrayList<>();
        
        int i = start;
        int j = mid + 1;
        
        while(i <= mid && j <= end) {
            if(nums[i] < nums[j]) {
                sortedArr.add(nums[i]);
                i++;
            } else {
                sortedArr.add(nums[j]);
                j++;
            } 
        }
        
        while(i <= mid) {
            sortedArr.add(nums[i]);
            i++;
        }
        
        while(j <= end) {
            sortedArr.add(nums[j]);
            j++;
        }
        
        for(int k = 0, index = start; k < sortedArr.size(); k++, index++) {
            nums[index] = sortedArr.get(k);
        }
    }
    
    private void mergeSort(int[] nums, int i, int j) {
        if(i < j) {
            int mid = (i + j) / 2;
            mergeSort(nums, i, mid);
            mergeSort(nums, mid + 1, j);
            merge(nums, i, mid, j);
        }
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}
/*

            [5,  2,  3,  1]
             0   1   2   3
                   |
                /     \
               /       \
        [5, 2]         [3, 1]
         0  1           2  3
           |
      /         \
    /              \
  [5]              [2]
  
             
*/