class Solution {
private:
    void sumNumbersUtil(TreeNode* root,int currSum,int& totalSum){
        if(!root)
            return;
        
        currSum = currSum * 10 + root->val;
        
        if(!root->left && !root->right)
        {
            totalSum += currSum;
            return;
        }
        
        sumNumbersUtil(root->left,currSum,totalSum);
        sumNumbersUtil(root->right,currSum,totalSum);
    }
    
public:
    int sumNumbers(TreeNode* root) {
        int totalSum = 0;
        sumNumbersUtil(root,0,totalSum);
        return totalSum;
    }
};