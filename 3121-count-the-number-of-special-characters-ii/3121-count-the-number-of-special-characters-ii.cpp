class Solution {
public:
    int numberOfSpecialChars(string word) {
        int n = word.size();
        unordered_map<char, int> mp1, mp2;
        for(int i = 0; i < n; i++){
            char ch = word[i];
            if(islower(ch)){
                mp1[ch] = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            char ch = word[i];
            if(isupper(ch)){
                if(mp2.find(ch) == mp2.end()){
                    mp2[ch] = i;
                }
            }
        }
        
        int count = 0;
        for(auto& data : mp1){
            char ch = 'A' + (data.first - 'a');
            if(mp2.find(ch) != mp2.end()){
                if(data.second < mp2[ch]){
                    count++;
                }
            }
        }
        
        return count;
    }
};