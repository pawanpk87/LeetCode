class Solution {
private:
    int findMaxSizeSubarraySum(vector<int>& nums, int target){
        if(target < 0)
            return -1;

        int n = nums.size();

        int i = 0, j = 0;
        int currSum = 0;
        int maxSize = -1;

        while(j<n){
            currSum += nums[j];
            
            while(i <= j && currSum > target){
                currSum -= nums[i++];
            }

            if(currSum == target)
                    maxSize = max(maxSize, (j-i+1));

            j++;
        }

        return maxSize;
    }
public:
    int minOperations(vector<int>& nums, int x) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int maxSize = findMaxSizeSubarraySum(nums, sum - x);
        return maxSize == -1 ? -1 : (n - maxSize);
    }
};