class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, 
                                vector<int>& potions, 
                                long long success) {
        int m = potions.size();
        
        sort(potions.begin(),potions.end());
        
        vector<int> result;
        
        int maxPotion = potions[m-1];
        
        for(auto& spell : spells){
            long long minPotion =  ceil((1.0 * success)/spell);
            
            if(minPotion > maxPotion){
                result.push_back(0);
                continue;
            }
            
            int index = lower_bound(potions.begin(),potions.end(),minPotion) - potions.begin();
            
            result.push_back(m-index);
        }
        
        return result;
    }
};