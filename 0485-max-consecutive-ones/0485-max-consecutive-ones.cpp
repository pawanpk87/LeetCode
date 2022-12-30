class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int maxOnes=0;
        int count=0;
        for(int i=0; i<nums.size(); i++)
        {
            if(nums[i] == 0)
            {
                maxOnes=max(maxOnes,count);
                count=0;
            }
            else
                count++;
        }
        maxOnes=max(maxOnes,count);
        return maxOnes;
    }
};