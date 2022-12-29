class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n=nums.size();
        
        multiset<int> st;
        for(int i=0; i<k; i++)
        {
            st.insert(nums[i]);
        }  
        
        vector<int> res;        
        
        int i=0,j=k;        
        while(j<n)
        {
            int currNum=*(st.rbegin());
            cout<<currNum<<" ";
            res.push_back(currNum);
            auto it=st.find(nums[i++]);
            st.erase(it);
            st.insert(nums[j++]);
        }
        res.push_back(*(st.rbegin()));
        return res;
    }
};