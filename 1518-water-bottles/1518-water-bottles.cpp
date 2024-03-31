class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        while(numBottles >= numExchange){
            int nextBottles = numBottles/numExchange + numBottles%numExchange;
            total += numBottles/numExchange;
            numBottles = nextBottles; 
        }
        return total;
    }
};