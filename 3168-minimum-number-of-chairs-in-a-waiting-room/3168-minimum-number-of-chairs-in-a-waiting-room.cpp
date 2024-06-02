class Solution {
public:
    int minimumChairs(string s) {
        int chairsNeeded = 0;
        int currChair = 0;
        for(auto& ch : s){
            if(ch == 'E'){
                if(currChair > 0){
                    currChair--;
                } else{
                   chairsNeeded++; 
                }
            } else{
                currChair++;
            }
        }
        return chairsNeeded;
    }
};