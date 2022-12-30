class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int n=nums.size();
        double maxAvg=INT_MIN;
        double sum=0;
        for(int i=0; i<k; i++)
        {
            sum+=nums[i];
        }
        int start=0, end=k;
        while(end<n)
        {
            cout<<sum<<endl;
            double tempAvg=sum/k;
            maxAvg=max(maxAvg,tempAvg);
            sum+=nums[end];
            sum-=nums[start];
            start++;
            end++;            
        }
        double tempAvg=sum/k;
        maxAvg=max(maxAvg,tempAvg);
        return maxAvg;
    }
};

