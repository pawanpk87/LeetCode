class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for(int num : nums) {
            if(containsEvenNumDigits(num)) {
                count++;
            }
        }   

        return count;
    }

    private boolean containsEvenNumDigits(int num) {
        int count = 0;

        while(num > 0) {
            count++;
            num = num/10;
        }

        return count % 2 == 0 ? true : false;
    }
}