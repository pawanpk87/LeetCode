class Solution {
    public String shiftingLetters(String str, int[] shifts) {
        int n = str.length();

        long[] count = new long[n];

        for(int i = 0; i < n; i++) {
            int startIndex = 0;
            int endIndex = i;
            int shift = shifts[i];

            count[startIndex] += shift;
            if(endIndex != n-1) {
                count[endIndex + 1] -= shift;
            }
        }

        for(int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }

        StringBuilder resStr = new StringBuilder();

        for(int i = 0; i < n; i++) {
            resStr.append(getShiftedChar(str.charAt(i), count[i]));
        } 

        return resStr.toString();
    }

    private char getShiftedChar(char ch, long shift) {
        long shiftedChar = ((ch - 'a') + shift) % 26;
        return (char) ('a' + shiftedChar);
    }
}