class Solution {
private:
    int distributeCoinsUtil(TreeNode* root,int& totalCoins)
    {
        if(!root)
            return 0;
        
        int leftCoins=distributeCoinsUtil(root->left,totalCoins);
        int rightCoins=distributeCoinsUtil(root->right,totalCoins);
        
        totalCoins+=abs(leftCoins) + abs(rightCoins);
        
        return root->val + leftCoins + rightCoins -1;
    }
    
public:
    int distributeCoins(TreeNode* root) {
        int totalCoins=0;
        distributeCoinsUtil(root,totalCoins);
        return totalCoins;
    }
};