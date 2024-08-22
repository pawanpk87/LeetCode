class Solution {
    public int findComplement(int num) {
        int bitCount = Integer.toBinaryString(num).length();
        int mask = (1 << bitCount) - 1;
        return num ^ mask;
    }
}