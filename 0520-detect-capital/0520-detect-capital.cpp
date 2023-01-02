class Solution {
private:
    bool isCapital(char ch)
    {
        return ch>='A' && ch<='Z';
    }
    
public:
    bool detectCapitalUse(string word) {
        for(int i=1; i<word.size(); i++)
        {
            if(isCapital(word[i]))
            {
                if(isCapital(word[i-1]) == false)
                    return false;
            }
            else if(!isCapital(word[i]))
            {
                if(isCapital(word[i-1]) && i!=1)
                    return false;                    
            }               
        }
        return true;
    }
};