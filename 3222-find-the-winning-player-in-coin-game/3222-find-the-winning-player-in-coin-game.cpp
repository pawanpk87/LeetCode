class Solution {
public:
    string losingPlayer(int x, int y) {
        bool alice = true;
        while(x > 0 || y > 0) {
           if(x > 0 && y >= 4) {
               x=x-1;
               y=y-4;
               alice = !alice;
           } else {
               return alice ? "Bob" : "Alice";
           }
        }
        return alice ? "Bob" : "Alice";
    }
};