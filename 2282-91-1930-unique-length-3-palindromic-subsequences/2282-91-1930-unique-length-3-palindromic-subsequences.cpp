class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int left[26];
        int right[26];

        memset(left,0,sizeof(left));
        memset(right,0,sizeof(right));

        unordered_set<string> res;
        
        for(int i=0; i<s.size(); i++){
            right[s[i]-'a']++;
        }
        
        for(int i=0; i<s.size(); i++){
            right[s[i]-'a']--;
            for(int j=0; j<26; j++) {
                if(right[j]>0 && left[j] > 0) {
                    string pal="";
                    pal+=j+'a';
                    pal+=s[i];
                    pal+=j+'a';
                    res.insert(pal);
                }
            }
            left[s[i]-'a']++;
        }

        return res.size();
    }
};