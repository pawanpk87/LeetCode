//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
private:
    void insertOne(stack<int>& st, int newNum){
        if(st.empty()){
            st.push(newNum);
        }else{
            int prevNum = st.top(); st.pop();
            insertOne(st,newNum);
            st.push(prevNum);
        }
    }
    
public:
    void Reverse(stack<int> &St){
        if(!St.empty()){
            int prevNum = St.top(); St.pop();
            Reverse(St);
            insertOne(St,prevNum);
        }
    }
};

//{ Driver Code Starts.


int main(){
    int T;
    cin>>T;
    while(T--){
        int N;
        cin>>N;
        stack<int> St;
        for(int i=0;i<N;i++){
            int x;
            cin>>x;
            St.push(x);
        }
        Solution ob;
        ob.Reverse(St);
        vector<int>res;
        while(St.size())
        {
            res.push_back(St.top());
            St.pop();
        }
        for(int i = res.size()-1;i>=0;i--)
        {
            cout<<res[i]<<" ";
        }
        
        cout<<endl;
    }
}
// } Driver Code Ends