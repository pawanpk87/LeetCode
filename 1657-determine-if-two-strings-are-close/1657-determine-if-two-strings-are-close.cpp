class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        vector<int> w1(26,0),w2(26,0),w3(26,0),w4(26,0);
        
        for(char ch : word1)
        {
            w1[ch-'a']++;
            w3[ch-'a']=1;
        }
        
        for(char ch : word2)
        {
            w2[ch-'a']++;
            w4[ch-'a']=1;
        }
        
        sort(w1.begin(),w1.end());
        sort(w2.begin(),w2.end());
        
        return w1 == w2 && w3 == w4;
    }
};