class Solution {
    private boolean isSumPresentUtil(int index, int sum, int[] nums) {
        if(sum == 0) {
            return true;
        }    
        
        if(index == nums.length) {
            return false;
        }
        
        if(nums[index] <= sum) {
            return isSumPresentUtil(index + 1, sum - nums[index], nums) ||
                   isSumPresentUtil(index + 1, sum, nums);
        } else {
            return isSumPresentUtil(index + 1, sum, nums);
        }
    }
    
    private boolean isSumPresent(int[] nums, int sum) {
        /*
            
            nums = [1,5,11,5]
            sum = 11
            
               0 1 2 3 4 5 6 7 8 9 10 11
            0 [] -> is possible to make sum 0 with element {0}
            1
            2      [] -> is possible to make sum 2 with element {0(0), 1(1), 2(5)}
            3
            4
        
        */
        
        int n = nums.length;
        
        boolean[][] isPossible = new boolean[n + 1][sum + 1];
    
        isPossible[0][0] = true;
        
        for(int i = 1; i <= n; i++) {
            isPossible[i][0] = true;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(nums[i - 1] <= j) {
                    isPossible[i][j] = isPossible[i - 1][j - nums[i - 1]] || isPossible[i - 1][j];
                } else {
                    isPossible[i][j] = isPossible[i - 1][j];
                }
            }
        }
        
        return isPossible[n][sum];
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int num : nums) {
            sum += num;
        }
        
        if(sum%2 != 0) {
            return false;
        }
        
        return isSumPresent(nums, sum/2);
    }
}