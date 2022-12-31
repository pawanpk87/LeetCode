class Solution {
private:
    int countSubaaray(vector<int>& nums,int range)
    {
        int totalCount=0;
        int count=0;
        for(int num : nums)
        {
            count=num <= range ? count+1 : 0;
            totalCount+=count;
        }
        return totalCount;
    }
    
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        return countSubaaray(nums,right) - 
               countSubaaray(nums,left-1);
    }
};