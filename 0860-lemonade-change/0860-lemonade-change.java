class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        for(int bill : bills) {
            if(bill == 5) {
                count5++;
            } else if(bill == 10) {
                if(count5 == 0) {
                    return false;
                }
                count5--;
                count10++;
            } else {
                if(count5 == 0) {
                    return false;
                }
                
                if(count10 == 0) {
                    if(count5 < 3){
                        return false;
                    }
                    count5 -= 3;
                } else {
                    count5--;
                    count10--;
                }
                
                count20++;
            } 
        }
        return true;
    }
}