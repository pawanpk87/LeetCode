class Solution {
    public int maximumSwap(int num) {
        int nums[] = convertIntoArray(num);
        
        int n = nums.length;
        
        int[] maxNum = new int[n];
        
        maxNum[n-1] = n-1;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] > nums[maxNum[i + 1]]) {
                maxNum[i] = i;
            } else {
                maxNum[i] = maxNum[i + 1];
            }
        }
        
        for(int i = 0; i < n-1; i++) {
            if(nums[i] < nums[maxNum[i + 1]]) {
                System.out.println("true");
                swap(nums, i, maxNum[i + 1]);
                break;
            }
        }
        
        return convertIntoNum(nums);
    }
    
    private int convertIntoNum(int[] nums) {
        int num = 0;
        
        for(int i = 0; i < nums.length; i++) {
            num = num * 10 + nums[i];
        }
        
        return num;
    }
    
    private int[] convertIntoArray(int num) {
        int[] nums = new int[String.valueOf(num).length()];
        
        int k = String.valueOf(num).length() - 1;
        
        while(num > 0) {
            int digit = num % 10;
            nums[k--] = digit;
            num = num / 10;
        }
        
        return nums;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tempNum = arr[i];
        arr[i] = arr[j];
        arr[j] = tempNum;
    }
}