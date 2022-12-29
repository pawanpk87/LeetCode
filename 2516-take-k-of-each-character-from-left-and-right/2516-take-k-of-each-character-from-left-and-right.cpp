class Solution {
public:
    int takeCharacters(string s, int k) {
        int n=s.size();
        
        unordered_map<char,int> freq;
        
        for(char ch : s)
        {
            freq[ch]++;
        }
        
        if(freq['a']<k || freq['b']<k || freq['c']<k)
            return -1;
        
        int size=0;
        int minSize=INT_MAX;
        
        for(int j=0,i=0; j<n; j++)
        {
            freq[s[j]]--;
            
            size++;
            
            while(freq[s[j]] < k)
            {
                freq[s[i]]++;
                size--;
                i++;
            }
            
            minSize=min(minSize,(n-size));
        }
        
        return minSize;
    }
};