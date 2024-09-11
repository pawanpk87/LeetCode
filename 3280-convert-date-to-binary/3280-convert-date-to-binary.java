class Solution {
    private String getBinaryStr(int num) {
        StringBuilder binaryStr = new StringBuilder();
        for(int i = 1; num != 0; i++) {
            int currBit = num & 1;
            binaryStr.append(currBit);
            num = num >> 1;
        }
        return binaryStr.reverse().toString();
    }

    public String convertDateToBinary(String date) {
        String dateInBinary = "";
        String[] d = date.split("-");
        dateInBinary = getBinaryStr(Integer.valueOf(d[0]));
        dateInBinary = dateInBinary + "-" + getBinaryStr(Integer.valueOf(d[1]));
        dateInBinary = dateInBinary + "-" + getBinaryStr(Integer.valueOf(d[2]));
        return dateInBinary;
    }
}