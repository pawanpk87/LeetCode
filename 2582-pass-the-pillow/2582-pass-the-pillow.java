class Solution {
    public int passThePillow(int n, int time) {
        int fr = time / (n - 1);
        int et = time % (n - 1);
        if(fr % 2 == 0){
            return et + 1;
        } else {
            return n - et;
        }
    }
}