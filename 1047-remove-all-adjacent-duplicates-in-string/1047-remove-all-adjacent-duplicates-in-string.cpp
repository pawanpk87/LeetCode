class Solution {
public:
    string removeDuplicates(string s) {
        string resStr;
        for(char ch : s)
        {
            if(resStr.size() == 0)
                resStr.push_back(ch);
            else if(resStr.back() == ch)
                resStr.pop_back();
            else
                resStr.push_back(ch);
        }
        return resStr;
    }
};