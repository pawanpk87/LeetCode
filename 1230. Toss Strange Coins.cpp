You have some coins.  The i-th coin has a probability prob[i] of facing heads when tossed.

Return the probability that the number of coins facing heads equals target if you toss every 
coin exactly once.

 

Example 1:

Input: prob = [0.4], target = 1
Output: 0.40000
Example 2:

Input: prob = [0.5,0.5,0.5,0.5,0.5], target = 0
Output: 0.03125
 

Constraints:

1 <= prob.length <= 1000
0 <= prob[i] <= 1
0 <= target <= prob.length
Answers will be accepted as correct if they are within 10^-5 of the correct answer.
  
class Solution {
private:
    vector<vector<double>> memo;
    
    double probabilityOfHeadsUtil(int index,vector<double>& prob,int target)
    {
        if(target < 0)
            return 0;
        
        if(index == prob.size()) 
            return target == 0 ? 1 : 0;
        
        if(memo[index][target] != -1)
            return memo[index][target];
        
        double probability = probabilityOfHeadsUtil(index+1,prob,target-1) * prob[index];
        probability+=probabilityOfHeadsUtil(index+1,prob,target) * (1 - prob[index]);
        
        return memo[index][target] = probability;
    }
    
public:
    double probabilityOfHeads(vector<double>& prob, int target) {
        memo.resize(1001,vector<double>(1001,-1));
        return probabilityOfHeadsUtil(0,prob,target);
    }
};
