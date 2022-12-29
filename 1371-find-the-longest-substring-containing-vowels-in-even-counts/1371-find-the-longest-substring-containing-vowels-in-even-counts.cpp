class Solution {
public:
    int findTheLongestSubstring(string s) {
        unordered_map<char,int> maskOfChar;
        
        int mask=1;
        maskOfChar['a']=mask;
        mask=mask*2;
        maskOfChar['e']=mask;
        mask=mask*2;
        maskOfChar['i']=mask;
        mask=mask*2;
        maskOfChar['o']=mask;
        mask=mask*2;
        maskOfChar['u']=mask;
        
        vector<int> seen(32,-1);
        
        mask=0;
        int maxLen=0;
        
        for(int i=0; i<s.size(); i++)
        {
            char ch=s[i];
            
            mask=mask ^ maskOfChar[ch];
            
            if(mask != 0 && seen[mask] == -1)
            {
                seen[mask]=i;
            }
            
            maxLen=max(maxLen,(i - seen[mask]));
        }
        
        return maxLen;
    }
};