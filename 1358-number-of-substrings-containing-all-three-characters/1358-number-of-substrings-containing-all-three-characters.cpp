class Solution {
public:
    int numberOfSubstrings(string s) {
        int count[3]={0,0,0};
        int totalCount=0;
        int i=0;
        for(int j=0; j<s.size(); j++)
        {
            count[s[j]-'a']++;
            while(count[0] && count[1] && count[2])
            {
                count[s[i]-'a']--;
                i++;
            }
            totalCount+=i;
        }
        return totalCount;
    }
};