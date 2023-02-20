class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n=nums.size();        
        int low=0;
        int heigh=nums.size()-1;
        int ans=-1;
        
        while(low<=heigh)
        {
            int mid=(low+heigh)/2;
            
            if(nums[mid] == target)
                return mid;            
            if(nums[mid] < target)
            {
                ans=mid;
                low=mid+1;          
            }
            else
            {
                heigh=mid-1;
            }
        }
        
        return (ans+1);
    }
};