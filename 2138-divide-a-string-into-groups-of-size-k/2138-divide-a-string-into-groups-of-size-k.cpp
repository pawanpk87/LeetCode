class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        int n = s.size();
        
        vector<string> groups;
        int currCount = k;
        string currGroup;
        
        for(int i=0; i<n; i++){
            currGroup.push_back(s[i]);
            if(--currCount == 0){
                groups.push_back(currGroup);
                currGroup = "";
                if(i != n-1)
                    currCount = k;
            }
        }
        
        if(currCount > 0){
            while(currCount--){
                currGroup.push_back(fill);
            }
            groups.push_back(currGroup);
        }
        
        return groups;
    }
};