class Solution {
private:
    vector<int> getPath(int node)
    {
        vector<int> path;
        
        while(node>0)
        {
            path.push_back(node);
            node=node/2;
        }
        
        return path;
    }
    
public:
    vector<int> cycleLengthQueries(int n, vector<vector<int>>& queries) {
        vector<int> res;
        
        for(auto& q : queries)
        {
            vector<int> path1=getPath(q[0]);
            vector<int> path2=getPath(q[1]);
            
            while(path1.size() > 0 && path2.size() > 0 &&
                  path1.back() == path2.back())
            {
                path1.pop_back();
                path2.pop_back();
            }
            
            res.push_back(1+path1.size()+path2.size());
        }
        
        return res;
    }
};