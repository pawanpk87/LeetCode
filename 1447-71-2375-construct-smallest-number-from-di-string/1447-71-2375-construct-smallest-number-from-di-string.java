class Solution {
    public static final int NUMBERS = 9;

    private boolean generateValidNum(
        int prevNum, 
        int index, 
        StringBuilder num, 
        String pattern, 
        boolean[] isNumUsed
    ) {
        if(index == pattern.length()) {
            return true;
        }

        for(int i = 1; i <= NUMBERS; i++) {
            if(!isNumUsed[i] && isValidNum(i, prevNum, pattern.charAt(index))) {
                isNumUsed[i] = true;
                num.append(i);

                if(generateValidNum(i, index + 1, num, pattern, isNumUsed)) {
                    return true;
                }

                num.deleteCharAt(num.length() - 1);
                isNumUsed[i] = false;
            }
        }

        return false;
    }

    private boolean isValidNum(int currNum, int prevNum, char type) {
        return type == 'I' ? currNum > prevNum : currNum < prevNum;
    }

    public String smallestNumber(String pattern) {
        boolean[] isNumUsed = new boolean[NUMBERS + 1];

        StringBuilder num = new StringBuilder();

        for(int i = 1; i <= NUMBERS; i++) {
            isNumUsed[i] = true;
            num.append(i);

            if(generateValidNum(i, 0, num, pattern, isNumUsed)) {
                return num.toString();
            }

            num.deleteCharAt(num.length() - 1);
            isNumUsed[i] = false;
        }

        return num.toString();
    }
}