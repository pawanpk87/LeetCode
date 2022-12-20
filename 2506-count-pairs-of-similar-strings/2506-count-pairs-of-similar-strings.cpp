class Solution {
public:
    int similarPairs(vector<string>& words) {
        int count=0;
        
        unordered_map<string,int> freq;
        
        for(string& s : words)
        {
            string sr=s;
            sort(sr.begin(),sr.end());
            unordered_set<char> st;
            string ns;
            
            for(char ch : sr)
            {
                if(st.find(ch) == st.end())
                {
                    ns.push_back(ch);
                    st.insert(ch);
                }
            }
            
            if(freq.find(ns) != freq.end())
            {
                count+=freq[ns];
            }
            
            freq[ns]++;
        }
        
        return count;
    }
};