You are given an inclusive range [lower, upper] and a sorted unique integer array nums,
where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, 
no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
Example 2:

Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
 

Constraints:

-109 <= lower <= upper <= 109
0 <= nums.length <= 100
lower <= nums[i] <= upper
All the values of nums are unique.
  
class Solution {
public:
    string getList(int lower,int upper)
    {
        if(lower == upper)
            return to_string(lower);
        return to_string(lower)+"->"+to_string(upper);
    }

    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> res;
        int expectedNum = lower;
        for(auto& num : nums)
        {
            if(num > upper)
                break;
                
            if(expectedNum == num)
                expectedNum++;
            else
            {
                res.push_back(getList(expectedNum,num-1));
                expectedNum = num+1;
            }
        }   
        if(expectedNum <= upper)
        {
            res.push_back(getList(expectedNum,upper));
        }

        return res;
    }
};
