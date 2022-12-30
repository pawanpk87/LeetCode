class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n=nums.size();
        vector<int> res(n);
        int index=n-1, leftIndex=0, rightIndex=n-1;
        while(index>=0)
        {
            if(abs(nums[leftIndex]) > abs(nums[rightIndex]))
            {
                res[index]=nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            }
            else
            {
                res[index]=nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }
            index--;
        }
        return res;
    }
};
