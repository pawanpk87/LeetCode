class Solution {
public:
    int partitionString(string s) {
        unordered_set<char> st;
        int subsetCount = 1;
        for(char ch : s){
            if(st.find(ch) != st.end()){
                subsetCount++;
                st.clear();
            }            
            st.insert(ch);
        }
        return subsetCount;
    }
};