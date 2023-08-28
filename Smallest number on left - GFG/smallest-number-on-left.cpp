//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    vector<int> leftSmaller(int n, int a[]){
        /*
         Inputs:-
                   1.)
                            {1, 5, 0, 3, 4, 5}
                            
                            -1, 1, -1, 0, 3, 4
                            
         
         Approachs:-
                    1.) O(N^2)
                    2.) 
                    
                        {1, 6, 2}
                        -1, 1, 1
                         
                        {
                            1,
                        }
            
        */
        vector<int> res;
        
        stack<int> st;
        
        for(int i=0; i<n; i++){
            int num = a[i];
            
            while(st.size()>0 && st.top() >= num){
                st.pop();
            }
            
            if(!st.empty() && st.top() < num){
                res.push_back(st.top());
            }else{
                res.push_back(-1);
            }
            
            st.push(num);
        }
        
        return res;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int a[n];
        for(int i = 0;i < n;i++)
            cin>>a[i];
        
        Solution ob;
        vector<int> ans = ob.leftSmaller(n, a);
        for(int i = 0;i < n;i++)
            cout<<ans[i]<<" ";
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends