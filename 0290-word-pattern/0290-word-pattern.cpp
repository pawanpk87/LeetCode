class Solution {
public:
    bool wordPattern(string pattern, string s) {
     
        unordered_map<char,string> char_map;
        unordered_map<string,char> str_map;

        stringstream str(s);
        string word;
        int n=pattern.size();
        int i=0;
        while(str >> word)
        {
            if(i == n)  return false;
            char ch=pattern[i];
            if(char_map.count(ch) != str_map.count(word)) return false;
            if(char_map.count(ch))
            {
                if(char_map[ch] != word || str_map[word] != ch) return false;
            }
            else
            {
                char_map[ch]=word;
                str_map[word]=ch;
            }
            i++;
        }
        return i==n;
    }
};