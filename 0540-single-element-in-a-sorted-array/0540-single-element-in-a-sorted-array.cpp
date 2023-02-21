class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        
        if(nums.size()==1)
            return nums[0];
        
        int low=0;
        int heigh=nums.size();
        
        while(low<=heigh)
        {
            int mid=(low+heigh)/2;
            if(mid%2==0)
            {
                int nextIndex=(mid+1)%nums.size();
                
                if(nums[mid]==nums[nextIndex])
                    low=mid+1;
                else
                    heigh=mid-1;
            }
            else
            {
                int prevIndex=(mid-1+nums.size())%nums.size();
                
                if(nums[mid]==nums[prevIndex])
                    low=mid+1;
                else
                    heigh=mid-1;
            }
        }
        
        return nums[low];
    }
};