public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 1; i <= 32; i++){
            if((n&1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}