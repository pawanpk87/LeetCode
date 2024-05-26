class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        int totalAbsent = 0;
        int currLate = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'A'){
                totalAbsent++;
                currLate = 0;
            } else if(s.charAt(i) == 'L'){
                currLate++;
            } else{
                currLate = 0;
            }
            if(totalAbsent > 1 || currLate >= 3){
                return false;
            }
        }
        return true;
    }
}