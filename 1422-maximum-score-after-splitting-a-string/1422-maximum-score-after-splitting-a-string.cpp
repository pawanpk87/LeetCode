class Solution {
public:
    int maxScore(string s) {
        int ones = 0;
        for(char ch : s){
            if(ch == '1') ones++;
        }
        int maxScore = 0;
        int zeros = 0;
        for(int i=0; i<s.size()-1; i++){
            char ch = s[i];
            if(ch == '0') zeros++;
            else ones--;
            maxScore = max(maxScore,ones + zeros);
        }

        return maxScore;
    }
};