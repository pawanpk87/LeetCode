class Solution {
    public int tribonacci(int n) {
        if(n < 2) {
            return n;
        }
        
        int[] tribonacciNumbers = new int[n+1];
        
        tribonacciNumbers[0] = 0;
        tribonacciNumbers[1] = 1;
        tribonacciNumbers[2] = 1;
        
        for(int i = 3; i <= n; i++) {
            tribonacciNumbers[i] = tribonacciNumbers[i-3] + 
                                   tribonacciNumbers[i-2] +
                                   tribonacciNumbers[i-1];
        }
        
        return tribonacciNumbers[n];
    }
}