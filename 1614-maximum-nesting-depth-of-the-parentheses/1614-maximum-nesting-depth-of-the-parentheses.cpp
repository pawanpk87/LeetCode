class Solution {
public:
    int maxDepth(string s) {
        
        
        int ans=INT_MIN;
        
        int open=0;       
        
        for(int i=0; i<s.size(); i++)
        {
            if(s[i] =='(')                
                open++;
            
            if(s[i] == ')')
                open--;
            
            ans=max(ans,open);     
        }
        
        return ans==INT_MIN ? 0 : ans;        
    }
};

