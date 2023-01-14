class DisjointSet{
private:
    vector<int> parent;
public:
    DisjointSet()
    {
        parent.resize(26);
        for(int i=0; i<26; i++)
        {
            parent[i]=i;
        }
    }
    
    int findParent(int node)
    {
        if(node == parent[node])
            return node;
        return parent[node]=findParent(parent[node]);
    }
    
    void unionNode(int node1,int node2)
    {
        int p1=findParent(node1);
        int p2=findParent(node2);
        
        if(p1 == p2)
            return;
        
        if(p1 > p2)
            parent[p1]=p2;
        else
            parent[p2]=p1;
    }
};

class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        DisjointSet obj;
        
        for(int i=0; i<s1.size(); i++)
        {
            obj.unionNode(s1[i]-'a',s2[i]-'a');
        }
        
        for(int i=0; i<baseStr.size(); i++)
        {
            baseStr[i]=(char)(obj.findParent(baseStr[i]-'a')+'a');
        }
        
        return baseStr;
    }
};