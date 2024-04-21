class Solution {
public:
    int numberOfSpecialChars(string word) {
        unordered_map<char, int> mp1, mp2;
        for(auto& ch : word){
            if(islower(ch)){
                mp1[ch]++;
            }
        }
        
        for(auto& ch : word){
            if(isupper(ch)){
                mp2[ch]++;
            }
        }
        
        int count = 0;
        for(auto& data : mp1){
            char ch = 'A' + (data.first - 'a');
            //cout<<data.first<<" -> "<<ch<<endl;
            if(mp2.find(ch) != mp2.end()){
                count++;
            }
        }
        
        return count;
    }
};