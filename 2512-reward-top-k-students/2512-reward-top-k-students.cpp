class Solution {
public:
    bool static cmp(vector<int>& a,vector<int>& b)
    {
        if(a[0] == b[0])
            return a[1]<b[1];
        else
            return a[0] > b[0];
    }
    
    vector<int> topStudents(vector<string>& positive_feedback, 
                            vector<string>& negative_feedback, 
                            vector<string>& report, 
                            vector<int>& student_id, 
                            int k) {
        
        unordered_set<string> pos,neg;
        
        for(string& positive : positive_feedback) pos.insert(positive);
        for(string& negative : negative_feedback) neg.insert(negative);
        
        unordered_map<int,int> marks;
        
        for(int i=0; i<report.size(); i++)
        {
            int score=0;
            stringstream ss(report[i]);
            string word;
            while(ss>>word)
            {
                if(pos.count(word)) score+=3;
                if(neg.count(word)) score-=1;
            }
            marks[student_id[i]]=score;
        }
        
        vector<vector<int>> res;
        
        for(auto& data : marks)
        {
            res.push_back({data.second,data.first});
        }
        
        sort(res.begin(),res.end(),cmp);
        
        vector<int> ans;
        
        for(int i=0; i<k; i++)
        {
            ans.push_back(res[i][1]);
        }
        
        return ans;
    }
};