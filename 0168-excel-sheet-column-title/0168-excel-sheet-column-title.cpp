class Solution {
public:
    string convertToTitle(int columnNumber) {
        string resStr = "";
        while(columnNumber){
            columnNumber--;
            char temp = 'A'+(columnNumber%26);
            resStr = temp+ resStr;
            columnNumber /= 26;
        }
        return resStr;
    }
};