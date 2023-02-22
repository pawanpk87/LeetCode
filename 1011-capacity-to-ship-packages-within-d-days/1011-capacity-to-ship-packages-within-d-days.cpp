class Solution {
public:
    bool isPossible(vector<int>& arr,int day,int capcity)
    {
        int count=1;
        int sum=0;
        for(int i=0; i<arr.size(); i++)
        {
            if(arr[i] > capcity)
                return false;
            sum+=arr[i];
            if(sum > capcity)
            {
                count++;
                sum=arr[i];
            }
            if(count > day)
                return false;
        }        
        return count <= day;
    }   
    
    int shipWithinDays(vector<int>& weights, int days) {
        int l=INT_MAX,h=0;
        for(int i=0; i<weights.size(); i++)
        {
            l=min(l,weights[i]);
            h+=weights[i];
        }
        
        while(l < h)
        {
            int mid=(l+h)/2;
            
            if(isPossible(weights,days,mid))
                h=mid;
            else
                l=mid+1;
        }
        
        return l;
    }
    
};