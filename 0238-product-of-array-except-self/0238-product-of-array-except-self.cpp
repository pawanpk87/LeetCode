class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        
        vector<int> product(n);
        
        int prevNum = 1;
        for(int i = n-1; i >= 0; i--){
            product[i] = prevNum;
            prevNum *= nums[i];
        }
        
        prevNum = 1;
        for(int i = 0; i < n; i++){
            product[i] *= prevNum;
            prevNum *= nums[i];
        }
        
        return product;
    }
};
/*
    
    nums = [1, 2, 3, 4]
            24 12 4  1
            24 12 8
            
        
        
            
 
*/