Given a 0-indexed integer array nums, return the number of subarrays of nums having an even product.

 

Example 1:

Input: nums = [9,6,7,13]
Output: 6
Explanation: There are 6 subarrays with an even product:
- nums[0..1] = 9 * 6 = 54.
- nums[0..2] = 9 * 6 * 7 = 378.
- nums[0..3] = 9 * 6 * 7 * 13 = 4914.
- nums[1..1] = 6.
- nums[1..2] = 6 * 7 = 42.
- nums[1..3] = 6 * 7 * 13 = 546.
Example 2:

Input: nums = [7,3,5]
Output: 0
Explanation: There are no subarrays with an even product.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
  
class Solution {
private:
    long long subarrayWithOddProduct(vector<int>& nums)
    {
        long long count=0;
        long long k=0;
        int start=-1;        
        
        for(int i=0; i<nums.size(); i++)
        {
            if(nums[i]%2 == 0)
            {
                k=(i-start-1);
                count+=(k * (k+1)/2);
                start=i;
            }
        }
        
        k=(nums.size()-start-1);
        
        count+=(k * (k+1)/2);
        
        return count;
    }
    
public:
    long long evenProduct(vector<int>& nums) {
        long long n=nums.size();
        long long totalSubarrays=(n * (n+1)/2);
        return totalSubarrays - subarrayWithOddProduct(nums);
    }
};
