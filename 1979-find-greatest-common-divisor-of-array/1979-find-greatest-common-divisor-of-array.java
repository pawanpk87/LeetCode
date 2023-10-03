class Solution {
    public int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
    
    public int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return gcd(min, max);
    }
}