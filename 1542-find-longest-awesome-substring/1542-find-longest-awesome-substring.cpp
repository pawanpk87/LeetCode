class Solution {
public:
    int longestAwesome(string s) {
        unordered_map<int,int> seen={{0,-1}};
        
        int maxLen=0;
        
        int bitMask=0;
        
        for(int i=0; i<s.size(); i++)
        {
            bitMask=bitMask ^ (1 << (s[i]-'0'));
            
            //Check if we have seen similar mask
            if(seen.find(bitMask) == seen.end())
                seen[bitMask]=i;
            else
                maxLen=max(maxLen,i-seen[bitMask]);
            
            //Check for masks that differ by one bit
            for(int index=0; index<10; index++)
            {
                int bitMask2=bitMask ^ (1<<index);
                if(seen.find(bitMask2) != seen.end())
                    maxLen=max(maxLen,i-seen[bitMask2]);
            }
        }
        
        return maxLen;
    }
};