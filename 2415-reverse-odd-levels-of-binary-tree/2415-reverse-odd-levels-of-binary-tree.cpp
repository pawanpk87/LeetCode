class Solution {
private:    
    void traverse(TreeNode* node1,TreeNode* node2,int level) {
        if(!node1 || !node2)
            return;
        
        if(level%2 != 0)
        {
            swap(node1->val,node2->val);
        }
        
        traverse(node1->left,node2->right,level+1);
        traverse(node1->right,node2->left,level+1);
    }
    
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        if(!root)
            return NULL;
        traverse(root->left,root->right,1);
        return root;
    }
};