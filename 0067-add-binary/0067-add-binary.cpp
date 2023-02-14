class Solution {
public:
    string addBinary(string a, string b) {
        int n=a.size(),m=b.size(),rem=0;
        int index1=n-1,index2=m-1;
        
        string res;
        
        while(index1>=0 && index2>=0)
        {
            int no=(rem+(a[index1]-'0')+(b[index2]-'0'));
            
            if(no % 2 == 0)
                res.push_back('0');
            else
                res.push_back('1');
            
            rem=no/2;
            
            index1--,index2--;
        }
        
        while(index1>=0)
        {
            int no=(rem+(a[index1]-'0'));
            
            if(no % 2 == 0)
                res.push_back('0');
            else
                res.push_back('1');
            
            rem=no/2;
            
            index1--; 
        }
        
        while(index2>=0)
        {
            int no=(rem+(b[index2]-'0'));
            
            if(no % 2 == 0)
                res.push_back('0');
            else
                res.push_back('1');
            
            rem=no/2;
            
            index2--; 
        }
        
        if(rem>0)
            res.push_back('1');
        
        reverse(res.begin(),res.end());
        
        return res;
    }
};