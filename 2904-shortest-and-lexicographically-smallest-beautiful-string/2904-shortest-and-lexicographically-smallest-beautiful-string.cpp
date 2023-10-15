class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.size();
        unordered_map<int, set<string>> mp;
        string res = "", currStr = "";
        int countOfOne = 0;
        int j = 0;
        while(j < n){
            currStr.push_back(s[j]);
            
            if(s[j] == '1')
                countOfOne++;
            
            if(countOfOne == k){
                while(countOfOne == k){
                    if(res == "")
                       res = currStr;
                    else if(res.size() > currStr.size()){
                        res = currStr;
                    }else if(res.size() == currStr.size()){
                        if(res > currStr)
                            res = currStr;
                    }
                    //cout<<res<<",";
                    if(currStr[0] == '1')
                        countOfOne--;
                    currStr.erase(0,1);
                }
                cout<<":-"<<currStr<<endl;
            }
            
            j++;
        }
        return res;
    }
};
/*

"0011101011011011 1 1"

 "11010110110111"

*/