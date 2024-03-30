class Solution {
public:
    int minimumLevels(vector<int>& possible) {
        int n = possible.size();
        
        vector<int> sufSum(n, 0);
        int currSum = 0;
        for(int i = n-1; i >= 0; i--){
            if(possible[i] == 0){
               currSum = currSum - 1; 
            } else{
               currSum = currSum + 1;
            }
            sufSum[i] = currSum;
        }
        
        //for(auto& a : sufSum) cout<<a<<" ";
        
        int minLevel = 0;
        currSum = 0;
        for(int i = 0; i < (n-1); i++){
            if(possible[i] == 0){
               currSum = currSum - 1; 
            } else{
               currSum = currSum + 1;
            }
            
            minLevel++;
            
            if(currSum > sufSum[i+1]){
                return minLevel;
            }
        }
        
        return -1;
    }
};