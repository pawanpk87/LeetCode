class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int n=nums.size();
        int maxOnes=0;
        int zeros=0;
        int i=0, j=0;
        
        while(j<n)
        {
            if(nums[j] == 0) 
                zeros++;
            
            if(zeros > k)
            {                
                maxOnes=max(maxOnes,(j-i));
                
                while(zeros > k)
                {
                    if(nums[i] == 0)
                        zeros--;
                    i++;
                }                
            }
            
            j++;
        }
        
        maxOnes=max(maxOnes,(j-i));
        
        return maxOnes;
    }
};