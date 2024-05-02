class Solution {
public:
    int findMaxK(vector<int>& nums) {
        set<int> st;
        for(auto& num : nums){
            st.insert(num);
        }
        int maxNum = -1;
        for(auto& num : st){
            if(num > 0){
                if(st.count((num * -1)) != 0){
                    maxNum = max(maxNum, num);
                }
            }
        }
        return maxNum;
    }
};