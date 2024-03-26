class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        
        for(int i = 0; i < n; i++){
            while((nums[i] > 0  && nums[i] <= n)&&
                  nums[nums[i] - 1] != nums[i]){
                swap(nums[nums[i] - 1], nums[i]);
            }
        }
        
        
        int smallestPositiveNum = 1;
        
        for(int i = 0; i < n; i++){
            if(nums[i]  > 0){
                if(nums[i] != smallestPositiveNum){
                    return smallestPositiveNum;
                }
                smallestPositiveNum++;
            }
        }
        
        return smallestPositiveNum;
    }
};