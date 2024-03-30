class Solution {
public:
    void add(vector<int>& ones, int num){
        for(int k = 0; k < 32; k++){
            if(num & (1 << k)){
                ones[k]++;
            }
        }
    }
    
    void remove(vector<int>& ones, int num){
        for(int k = 0; k < 32; k++){
            if(num & (1 << k)){
                ones[k]--;
            }
        }
    }
    
    int getNum(vector<int>& ones){
        long long num = 0;
        for(int k = 0; k < 32; k++){
            if(ones[k]){
                num += (long long)pow(2, k);
            }
        }
        return num;
    }
    
    int minimumSubarrayLength(vector<int>& nums, int k) {
        int n = nums.size();
        
        vector<int> ones(32, 0);
        
        int minLen = INT_MAX;
        long long currNum;
        int i = 0, j = 0;
        while(j < n){
            add(ones, nums[j]);
            currNum = getNum(ones);
            while(currNum >= k && i <= j){
                minLen = min(minLen, (j - i + 1));
                remove(ones, nums[i]);
                currNum = getNum(ones);
                i++;
            }
            j++;
            
            cout<<endl;
        }
        
        return minLen == INT_MAX ? -1 : minLen;
    }
};