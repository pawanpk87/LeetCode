class Solution {
public:
    vector<int> occurrencesOfElement(vector<int>& nums, vector<int>& queries, int x) {
        int n = nums.size();
        unordered_map<int, int> mp;
        int count = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] == x){
                mp[count] = i;
                count++;
            }
        }
        vector<int> res;
        for(int a : queries){
            if(mp.find(a) != mp.end()){
                res.push_back(mp[a]); 
            } else{
                res.push_back(-1);
            }
        }
        return res;
    }
};