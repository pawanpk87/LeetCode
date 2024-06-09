class Solution {
private:
    unordered_map<int, int> mp;
    int solve(int x, vector<int>& rewardValues, set<int>& visited){
        if(mp.find(x) != mp.end()){
            return mp[x];
        }
        int maxRewards = x;
        for(int i = 0; i < rewardValues.size(); i++){
            if(visited.count(i) == 0 && x < rewardValues[i]){
                visited.insert(i);
                maxRewards = max(maxRewards, solve(x + rewardValues[i], rewardValues, visited));
                visited.erase(i);
            }
        }
        return mp[x] = maxRewards;
    }
public:
    int maxTotalReward(vector<int>& rewardValues) {
        set<int> visited;
        int res = solve(0, rewardValues, visited);
        return res;
    }
};