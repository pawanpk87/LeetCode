class Solution {
public:
    vector<int> resultArray(vector<int>& nums) {
        int n = nums.size();
        
        vector<int> arr1, arr2;
        
        arr1.push_back(nums[0]);
        arr2.push_back(nums[1]);
        
        for(int i = 2; i < n; i++){
            if(arr1[arr1.size()-1] > arr2[arr2.size()-1]){
                arr1.push_back(nums[i]);
            }else{
                arr2.push_back(nums[i]);
            }
        }
        
        vector<int> result;
        for(auto& a : arr1) result.push_back(a);
        for(auto& b : arr2) result.push_back(b);
        
        return result;
    }
};