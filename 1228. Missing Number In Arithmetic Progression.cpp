In some array arr, the values were in arithmetic progression: the values 
arr[i + 1] - arr[i] are all equal for every 0 <= i < arr.length - 1.

A value from arr was removed that was not the first or last value in the array.

Given arr, return the removed value.

 

Example 1:

Input: arr = [5,7,11,13]
Output: 9
Explanation: The previous array was [5,7,9,11,13].
Example 2:

Input: arr = [15,13,12]
Output: 14
Explanation: The previous array was [15,14,13,12].
 

Constraints:

3 <= arr.length <= 1000
0 <= arr[i] <= 105
The given array is guaranteed to be a valid array.
  
class Solution {
public:
    int missingNumber(vector<int>& arr) {
        int n = arr.size();
        int diff = (arr[n-1] - arr[0])/n;
        int expected = arr[0];
        for(int i=0; i<n; i++)
        {
            if(expected != arr[i])
                return expected;
            expected = arr[i] + diff;
        }
        return expected;
    }
};
  
  
