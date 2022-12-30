class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int prevSum=0;
        for(int i=0; i<nums.size(); i++)
        {
            prevSum+=(i+1);
            prevSum-=nums[i];
        }
        return prevSum;
    }
};
