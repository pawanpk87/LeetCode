class Solution {
public:
    int minimizeArrayValue(vector<int>& nums) {        
        long long answer = 0, prefixSum = 0;        
        for (int i = 0; i < nums.size(); ++i) {
            prefixSum += nums[i];
            answer = max(answer, (prefixSum + i) / (i + 1));
        }        
        return answer;
    }
};