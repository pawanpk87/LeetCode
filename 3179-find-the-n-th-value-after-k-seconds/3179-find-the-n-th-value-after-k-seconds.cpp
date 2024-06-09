class Solution {
public:
    int valueAfterKSeconds(int n, int k) {
        vector<int> nums;
        int mod = 1000000007;
        for(int i = 0; i < n; i++){
            nums.push_back(1);
        }
        while(--k){
            for(int i = 1; i < n; i++){
                nums[i] = (nums[i] + nums[i-1]) % mod;
            }
        }
        int sum = 0;
        for(int i = 0; i <n; i++){
            sum = (sum + nums[i]) % mod;
        }
        return sum;
    }
};