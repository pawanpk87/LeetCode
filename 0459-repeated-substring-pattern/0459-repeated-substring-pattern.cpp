class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int n = s.size();
        
        string tempStr = "";
        
        for(int i=1; i<=n/2; i++){
            if(n%i == 0){                
                for(int j=1; j<=n/i; j++){
                    tempStr += s.substr(0,i);
                }
                if(tempStr == s)
                    return true;
                tempStr = "";
            }
        }
        
        return false;
    }
};

/*

    Observation:- 
                1.) substring size should divide the string size
                    n/m == 0
                    
    Solution:- 
    
        1.)
                1.) Iterator from 1 to n/2
                2.) check if n/i
                        a.) create string 
                        
                test:-  s = "abcabcabcabc"
                             |
                             
                             
                             

*/