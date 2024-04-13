class Solution {
public:
    int scoreOfString(string s) {
        int sum = 0;
        for(int i = 0; i < s.size()-1; i++){
            int a = (int) s[i];
            int b = (int) s[i+1];
            sum += abs(a - b);
        }
        return sum;
    }
};