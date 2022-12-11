class Allocator {
private:
    int n;
    vector<int> memo;
    
public:    
    Allocator(int n) {
        this->n=n;
        memo.resize(n);
    }
    
    int allocate(int size, int mID) {
        int start=-1;
        int count=0;
        
        for(int i=0; i<n; i++)
        {
            if(memo[i] == 0)
            {
                if(count == 0)
                    start=i;
                
                count++;
                
                if(count >= size)
                {
                    for(int j=0; j<count; j++)
                    {
                        memo[start+j]=mID;
                    }
                    
                    return start;
                }
            }
            else
            {
                start=-1;
                count=0;
            }
        }
        
        return -1;
    }
    
    int free(int mID) {
        int count=0;
        
        for(int i=0; i<n; i++)
        {
            if(memo[i] == mID)
            {
                count++;
                memo[i]=0;
            }
        }
        
        return count;
    }
};
