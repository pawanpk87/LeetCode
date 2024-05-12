class Solution {
public:
    int maximumEnergy(vector<int>& energy, int k) {
        int n = energy.size();
        
        vector<int> sum(n);
        
        for(int i = 0; i < k; i++) sum[n - i - 1] = energy[n - i - 1];
        for(int i = n - k - 1; i >= 0; i--){
            sum[i] = (energy[i] + sum[i + k]);
        }
        
        int maxNum = INT_MIN;
        
        for(int i = 0; i < n; i++){
            maxNum = max(maxNum, sum[i]);
        }
        
        return maxNum;
    }
};