class Solution {
public:
    int minMoves2(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        int midNum = nums[n/2];
        int sum = 0;
        for(auto& num : nums){
            sum += abs(num - midNum);
        }
        return sum;
    }
};