class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int n = nums.size();
        
        for(int i = 0; i < n; i++){
            while(nums[nums[i]] != nums[i]){
                swap(nums[nums[i]], nums[i]);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != nums[i]){
                return nums[i];
            }
        }
        
        return -1;
    }
};