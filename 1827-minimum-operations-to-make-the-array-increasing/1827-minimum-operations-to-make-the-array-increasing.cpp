class Solution {
public:
    int minOperations(vector<int>& nums) {
        int minOp=0;
        for(int i=1; i<nums.size(); i++)
        {
            if(nums[i] <= nums[i-1])
            {
                int newNum=nums[i-1]+1;
                minOp+=abs(newNum-nums[i]);
                nums[i]=newNum;
            }
        }
        return minOp;
    }
};
