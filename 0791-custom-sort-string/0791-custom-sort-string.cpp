class Solution {
private:
    static unordered_map<char, int> alphabet;
public:
    static bool cmp(char a, char b){
        return alphabet[a] < alphabet[b];
    }
    
    string customSortString(string order, string s) {
        for(char ch = 'a' ; ch <= 'z'; ch++){
            alphabet[ch] = -1;
        }      
        
        int seqNum = 1;
        for(auto& ch : order){
          alphabet[ch] = seqNum++;  
        }
        
        sort(s.begin(), s.end(), cmp);
        
        return s;
    }
};

unordered_map<char, int> Solution:: alphabet;