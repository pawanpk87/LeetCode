class Solution {
public:
    bool closeStrings(string word1, string word2) {
        if(word1.size() != word2.size())
            return false;
        
        map<char,int> freq1,freq2;
        
        for(char ch : word1) freq1[ch]++;
        for(char ch : word2) freq2[ch]++;
        
        for(char ch : word1)
        {
            if(freq2.find(ch) == freq2.end())
                return false;
        }
        
        for(char ch : word2)
        {
            if(freq1.find(ch) == freq1.end())
                return false;
        }
                
        vector<int> fArray1,fArray2;
        
        for(auto& data : freq1) fArray1.push_back(data.second);
        for(auto& data : freq2) fArray2.push_back(data.second);
        
        sort(fArray1.begin(),fArray1.end());
        sort(fArray2.begin(),fArray2.end());
               
        for(int i=0; i<fArray1.size(); i++)
        {
            if(fArray1[i] != fArray2[i])
                return false;
        }
        
        return true;
    }
};