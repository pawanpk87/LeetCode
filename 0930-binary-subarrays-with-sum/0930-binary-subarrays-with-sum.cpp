class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        int start = 0;
        int prefixZeros = 0;
        int currentSum = 0;
        int totalCount = 0;
        for(int end = 0; end < nums.size(); end++){
            currentSum += nums[end];
            while(start < end && (nums[start] == 0 || currentSum > goal)){
                if(nums[start] == 1){
                    prefixZeros = 0;
                }else{
                    prefixZeros++;
                }
                currentSum -= nums[start];
                start++;
            }
            if(currentSum == goal){
                totalCount += 1 + prefixZeros;
            }
        }
        return totalCount;
    }
};