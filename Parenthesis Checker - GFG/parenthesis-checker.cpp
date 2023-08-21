//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to check if brackets are balanced or not.
    bool ispar(string x)
    {
        stack<char> st;
        for(char currChar : x){
            if(st.empty()){
                st.push(currChar);
            }else if(
              st.top() == '{' && currChar == '}' ||
              st.top() == '(' && currChar == ')' ||
              st.top() == '[' && currChar == ']'
            ){
                st.pop();
            }else{
                st.push(currChar);
            }
        }
        return st.empty();
    }

};

//{ Driver Code Starts.

int main()
{
   int t;
   string a;
   cin>>t;
   while(t--)
   {
       cin>>a;
       Solution obj;
       if(obj.ispar(a))
        cout<<"balanced"<<endl;
       else
        cout<<"not balanced"<<endl;
   }
}
// } Driver Code Ends