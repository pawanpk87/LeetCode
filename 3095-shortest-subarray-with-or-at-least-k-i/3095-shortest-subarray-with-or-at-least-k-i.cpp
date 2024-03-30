class Solution {
public:
    int minimumSubarrayLength(vector<int>& nums, int k) {
        int n = nums.size();
        int minLen = INT_MAX;
        for(int s = 1; s <= n; s++){
            for(int i = 0, j = s-1; j < n; i++, j++){
                int bitOr = nums[i];
                for(int l = i+1; l <= j; l++){
                    bitOr = bitOr | nums[l];
                }
                if(bitOr >= k){
                    if(minLen > (j - i + 1)){
                        minLen = (j - i + 1);
                    }
                }
            }
        }
        return minLen == INT_MAX ? -1 : minLen;
    }
};