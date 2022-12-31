//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution{
    public:
    long countSubaaray(int nums[],int n,int range)
    {
        long totalCount=0;
        long count=0;
        for(int i=0; i<n; i++)
        {
            int num=nums[i];
            count=num <= range ? count+1 : 0;
            totalCount+=count;
        }
        return totalCount;
    }
    
    long countSubarrays(int a[], int n, int L, int R)
    {
        return countSubaaray(a,n,R) - 
               countSubaaray(a,n,L-1);
    }
};

//{ Driver Code Starts.
// driver program
int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        
        int n ,l,r;
        cin >> n>>l>>r;
        int a[n];
        for(int i=0;i<n;i++)
        cin >> a[i];
        Solution ob;
    	cout << ob.countSubarrays(a, n, l, r)<<endl;
    }
	return 0;
}

// } Driver Code Ends