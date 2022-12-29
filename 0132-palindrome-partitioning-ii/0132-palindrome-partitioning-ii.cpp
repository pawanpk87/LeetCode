class Solution {
private:
    vector<vector<int>> memo;
    
    bool isPalindrome(string& s,int start,int end)
    {
        while(start < end)
        {
            if(s[start] != s[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    int minPartition(string& s,int startIndex,int endIndex)
    {
        if(startIndex == endIndex || 
           isPalindrome(s,startIndex,endIndex))
            return 0;
        
        if(memo[startIndex][endIndex] != -1)
            return memo[startIndex][endIndex];
        
        int minPart=INT_MAX;
        
        for(int i=startIndex; i<=endIndex; i++)
        {
            if(isPalindrome(s,startIndex,i))
            {
               minPart=min(minPart,1+minPartition(s,i+1,endIndex));         
            }
        }
        
        return memo[startIndex][endIndex]=minPart;
    }
    
public:
    int minCut(string s) {
        int n=s.size();
        memo.resize(n+1,vector<int>(n+1,-1));
        return minPartition(s,0,n-1);
    }
};