class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root)
            return NULL;
        
        TreeNode* left=lowestCommonAncestor(root->left,p,q);
        TreeNode* right=lowestCommonAncestor(root->right,p,q);
        
        if(left!=NULL && right!=NULL)
            return root;
        else if(left==p && root==q)
            return root;
        else if(right==q && root==p)
            return root;
        
        if(p == root || q == root)
            return root;
        
        return left == NULL ? right : left;
    }
};