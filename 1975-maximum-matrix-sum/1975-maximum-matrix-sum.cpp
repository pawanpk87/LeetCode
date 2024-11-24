class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        long long ans=0;
        int minElement=INT_MAX;
        int negative=0;
        
        for(int i=0; i<matrix.size(); i++) {
            for(auto x : matrix[i]) {
                ans+=abs(x);
                
                if(minElement > abs(x))
                    minElement=abs(x);
                
                if(x < 0) negative++;
            }
        }
        
        if(negative%2==0)
            return ans;
        
        return ans-2*minElement;
    }
};