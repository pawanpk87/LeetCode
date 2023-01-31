class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        
        int n=ages.size();
        vector<pair<int,int>> modifyScores;
        
        for(int i=0; i<n; i++)
        {
            modifyScores.push_back({ages[i],scores[i]});
        }
        
        sort(modifyScores.begin(),modifyScores.end());
        
        vector<int> ans(n,0);
        
        int best=0;
        for(int i=0; i<n; i++)
        {
            ans[i]=modifyScores[i].second;
            
            for(int j=0; j<i; j++)
            {
                if(modifyScores[i].second >= modifyScores[j].second)
                {
                    ans[i]=max(ans[i],ans[j]+modifyScores[i].second);
                }
            }
            
            best=max(best,ans[i]);
        }
        
        return best;
    }
};