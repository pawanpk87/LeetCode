class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        int n = tokens.size();
        
        sort(tokens.begin(), tokens.end());
        
        int low = 0, heigh = n-1;
        int score = 0;
        
        while(low <= heigh){
            if(power >= tokens[low]){
                score++;
                power -= tokens[low++];
            }else if(score > 0 && low < heigh){
                score--;
                power += tokens[heigh--];
            }else{
                return score;
            }
        }
        
        return score;
    }
};