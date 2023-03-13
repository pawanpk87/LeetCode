//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    private:
    
    void createSubsets(vector<int>& arr,vector<int> currSubset,int currIndex,int n,set<vector<int>>& st){
        if(currIndex >= n)
        {
            st.insert(currSubset);
            return;
        }
        
        currSubset.push_back(arr[currIndex]);
        createSubsets(arr,currSubset,currIndex+1,n,st);
        currSubset.pop_back();
        createSubsets(arr,currSubset,currIndex+1,n,st);
    }
    
    public:
    
    vector<vector<int> > AllSubsets(vector<int> arr, int n){
        sort(arr.begin(),arr.end());
        set<vector<int>> st;
        vector<int> currSubset;
        createSubsets(arr,currSubset,0,n,st);
        vector<vector<int>> allSubsets(st.begin(),st.end());
        return allSubsets;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<int> A;
        int x;
        for(int i=0;i<n;i++){
            cin>>x;
            A.push_back(x);
        }
        Solution obj;
        vector<vector<int> > result = obj.AllSubsets(A,n);
        // printing the output
        for(int i=0;i<result.size();i++){
            cout<<'(';
            for(int j=0;j<result[i].size();j++){
                cout<<result[i][j];
                if(j<result[i].size()-1)
                    cout<<" ";
            }
            cout<<")";
        }
        cout<<"\n";
    }
}   



// } Driver Code Ends