class Solution {
    private boolean isPossible(int index, int currNum, int targetNum, String nums) {
        if(index == nums.length()) {
            return currNum == targetNum;
        }

        if(currNum > targetNum) {
            return false;
        }

        boolean result = false;

        for(int i = index; i < nums.length(); i++) {
            String subNumStr = nums.substring(index, i + 1);
            int subNum = Integer.parseInt(subNumStr);

            result = result || isPossible(i + 1, currNum + subNum, targetNum, nums);

            if(result) {
                break;
            }
        }

        return result;
    }

    public int punishmentNumber(int n) {
        int punishmentNum = 0;

        for(int num = 1; num <= n; num++) {
            int sqrNum = num * num;
            String sqrNumStr = String.valueOf(sqrNum);

            if(isPossible(0, 0, num, sqrNumStr)) {
                punishmentNum += sqrNum;
            }
        }   

        return punishmentNum;
    }
}