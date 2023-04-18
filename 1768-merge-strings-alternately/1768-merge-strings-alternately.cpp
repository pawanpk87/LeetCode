class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int n = word1.size(), m = word2.size();
        int i = 0, j = 0;
        string resWord;
        
        while(i<n && j<m){
            resWord.push_back(word1[i++]);
            resWord.push_back(word2[j++]);
        }
        
        while(i<n){
            resWord.push_back(word1[i++]);
        }
        
        while(j<m){
            resWord.push_back(word2[j++]);
        }
        
        return resWord;
    }
};