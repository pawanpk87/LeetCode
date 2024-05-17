class Solution {
    public boolean isHappy(int n) {
        long slow = n;
        long fast = sumOfSquares(n);
        while(fast != 1 && slow != fast){
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }
    
    private long sumOfSquares(long num){
        long sum = 0;
        while(num != 0){
            long digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }
}