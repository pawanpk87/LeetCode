class Solution {
public:
    string compressedString(string word) {
        int n = word.size();
        string comp = "";
        int i = 0;
        while(i < n){
            int count = 1;
            char ch = word[i];
            i++;
            while(i < n && count < 9 && word[i] == ch){
                count++;
                i++;
            }
            comp += to_string(count) + ch;
        }
        return comp;
    }
};