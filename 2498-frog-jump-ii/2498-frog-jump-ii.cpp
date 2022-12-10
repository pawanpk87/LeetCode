class Solution {
public:
    int maxJump(vector<int>& stones) {
        int one=0, two=0;
        
        int minCost=0;
        
        for(int i=1; i<stones.size(); i++)
        {
            if(i%2 == 0)
            {
                minCost=max(minCost,stones[i] - one);
                one=stones[i];
            }
            else
            {
                minCost=max(minCost,stones[i]-two);
                two=stones[i];
            }
        }
        
        return minCost;
    }
};