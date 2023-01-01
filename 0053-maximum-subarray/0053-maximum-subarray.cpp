class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max_sum_so_far=INT_MIN;
        int curr_sum_so_far=0;
        for(int num : nums)
        {
            curr_sum_so_far+=num;
            if(curr_sum_so_far < num)
                curr_sum_so_far=num;
            if(max_sum_so_far < curr_sum_so_far)
                max_sum_so_far=curr_sum_so_far;
        }
        return max_sum_so_far;
    }
};