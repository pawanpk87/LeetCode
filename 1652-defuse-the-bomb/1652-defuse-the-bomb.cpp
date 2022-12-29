class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        int n=code.size();
        
        int sIndex=1, eIndex=k;
        
        if(k < 0)
            k=-1*k, sIndex=n-k, eIndex=n-1;
        
        int windowSum=0;
        
        for(int i=sIndex; i<=eIndex; i++) 
        {
            windowSum+=code[i];
        }
        
        vector<int> res(n);
        
        for(int i=0; i<n; i++)
        {
            res[i]=windowSum;
            windowSum-=code[(sIndex++)%n];
            windowSum+=code[(++eIndex)%n];
        }
        
        return res;        
    }
};