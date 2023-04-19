/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int ans=0;
    
    void solve(TreeNode* root,char step,int count)
    {
        if(!root)
            return;
        ans=max(ans,count);
        if(step == 'L')
        {
            if(root->left)
                solve(root->left,'R',count+1);
            if(root->right)
                solve(root->right,'L',1);
        }
        else
        {
            if(root->right)
                solve(root->right,'L',count+1);
            if(root->left)
                solve(root->left,'R',1);
        }    
    }
    
    
    
    int longestZigZag(TreeNode* root) {
        
        solve(root,'R',0);
        return ans;
    }
};