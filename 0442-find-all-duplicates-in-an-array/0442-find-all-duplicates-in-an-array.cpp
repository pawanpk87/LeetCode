class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        int n = nums.size();
        
        vector<int> dublicates;
        
        for(int i = 0; i < n; i++){
            while(nums[nums[i] - 1] != nums[i]){
                swap(nums[nums[i] - 1], nums[i]);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i+1 != nums[i]){
                dublicates.push_back(nums[i]);
            }
        }
        
        return dublicates;
    }
};