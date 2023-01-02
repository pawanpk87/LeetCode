class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char,int>> st;
        
        for(char ch : s)
        {
            if(st.size() >= k-1)
            {
                if(st.top().first == ch && 
                   st.top().second == k-1)
                {
                    int tempK=k;
                    while(--tempK)
                    {
                        st.pop();
                    }
                    continue;
                }
            }
            
            if(st.empty()) st.push({ch,1});
            else
            {
                if(st.top().first == ch)
                    st.push({ch,st.top().second+1});
                else
                    st.push({ch,1});
            }
        }
        
        string res;
        while(st.size() > 0)
        {
            res.push_back(st.top().first);
            st.pop();
        }
        
        reverse(res.begin(),res.end());
        
        return res;
    }
};
