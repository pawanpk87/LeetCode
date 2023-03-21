class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        int n = nums.size();
        
        long long count = 0;
        
        long long currCount = 0;        
        int j=0;
        
        while(j<n){
            if(nums[j] == 0)
                currCount++;
            else{
                currCount = 0;   
            }            
            count += currCount;
            j++;
        }
        
        return count;
    }
};