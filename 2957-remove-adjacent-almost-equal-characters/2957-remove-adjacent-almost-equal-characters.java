class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int n = word.length();
        int minOperations = 0;
        for(int i = 1; i < n; i++){
            char ch1 = word.charAt(i-1);
            char ch2 = word.charAt(i);
            if(ch1 == ch2 || Math.abs(ch1 - ch2) == 1){
                minOperations++;
                i++;
            }
        }
        return minOperations;
    }
}