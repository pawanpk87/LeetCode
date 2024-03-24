class Solution {
public:
    int minOperations(int k) {
        int minCount = INT_MAX;
        int currNum = 1, currCount = 0;
        while(--k){
            if(k%currNum == 0){
                minCount = min(minCount, currCount + (k/currNum));
            } else{
                minCount = min(minCount, currCount + (k/currNum) + 1);
            }
            currCount++;
            currNum++;
        }
        return minCount == INT_MAX ? 0 : minCount;
    }
};