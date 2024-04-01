class Solution {
public:
    int lengthOfLastWord(string s) {
        int n = s.size();
        int length = 0;
        int index = n-1;
        
        while(index >= 0 && s[index] == ' '){
            index--;
        }
        
        while(index >= 0 && s[index] != ' '){
            index--;
            length++;
        }
        
        return length;
    }
};