class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int mp1[256];
        int mp2[256];
        
        memset(mp1,-1,sizeof(mp1));
        memset(mp2,-1,sizeof(mp1));
        
        for(int i=0; i<s.size(); i++)
        {
            int ch1=s[i];
            int ch2=t[i];
            
            if(mp1[ch1] == -1 && mp2[ch2] == -1)
            {
                mp1[ch1]=ch2;
                mp2[ch2]=ch1;
            }
            else if(!(mp1[ch1] == ch2 && mp2[ch2] == ch1))
                return false;
        }
        
        return true;
    }
};