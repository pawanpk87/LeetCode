class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int totalTankGas = 0;
        int currTankGas = 0;
        int startIndex = 0;
        for(int i=0; i<gas.size(); i++)
        {
            totalTankGas += gas[i] - cost[i];
            currTankGas += gas[i] - cost[i];
            if(currTankGas < 0)
            {
                currTankGas = 0;
                startIndex = i+1;
            }
        }
        return totalTankGas >= 0 ? startIndex : -1;
    }
};