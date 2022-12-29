class Solution {
public:
    int captureForts(vector<int>& forts) {
        int res=0;
        
        for(int i=0,j=0; i<forts.size(); i++)
        {
            if(forts[i] != 0)
            {
                if(forts[i] == -forts[j])
                {
                    res=max(res,(i-j-1));   
                }
                j=i;
            }
        }
        
        return res;
    }
};