class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        unordered_map<int,int> mp;
        int count=0;
        for(int n : nums)
        {
            int i=2;
            while(n>1)
            {
                if(n%i==0){
                    mp[i]++;
                    n/=i;
                }
                else i++;
            }
        }
        return mp.size();
    }
};