class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if((!p && q) || (p && !q))
            return false;
        
        if(!p && !q)
            return true;
        
        return p->val == q->val &&
               isSameTree(p->left,q->left) &&
               isSameTree(p->right,q->right);
    }
};