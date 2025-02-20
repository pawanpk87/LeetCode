class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        StringBuilder resBinaryStr = new StringBuilder();

        for(int i = 0; i < n; i++) {
            char ch = nums[i].charAt(i);
            resBinaryStr.append(ch == '1' ? '0' : '1');
        }

        return resBinaryStr.toString();
    }
}