class Solution {
private:
    vector<vector<int>> allCandidates;
    
    void combinationSumUtil(int currIndex, int target, vector<int>& candidates, vector<int>& chosenCandidates){
        if(target == 0){
            allCandidates.push_back(chosenCandidates); 
            return;
        }
        
        if(currIndex == candidates.size()){
            return;
        }
        
        if(candidates[currIndex] <= target){
            chosenCandidates.push_back(candidates[currIndex]);
            combinationSumUtil(currIndex, target - candidates[currIndex], candidates, chosenCandidates);
            chosenCandidates.pop_back();
            
            combinationSumUtil(currIndex + 1, target, candidates, chosenCandidates);
        } else{
            combinationSumUtil(currIndex + 1, target, candidates, chosenCandidates);
        }
    }
    
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> chosenCandidates;
        combinationSumUtil(0, target, candidates, chosenCandidates);
        return allCandidates;
    }
};