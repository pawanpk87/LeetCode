class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();
        
        if(n == 1){
            return 0;
        }
        
        int maxLen = 0;
        unordered_map<int, int> indexNum;
        int currNum = 0;
        
        indexNum[currNum] = -1;
        
        for(int i = 0; i < n; i++){
            currNum += nums[i] == 0 ? -1 : 1;
            if(indexNum.find(currNum) != indexNum.end()){
                maxLen = max(maxLen, i - indexNum[currNum]);
            } else{
                indexNum[currNum] = i;
            }
        }
        
        return maxLen;
    }
};