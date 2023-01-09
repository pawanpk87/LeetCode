class Solution {
private:
    void preorderTraversalUtil(TreeNode* root,vector<int>& list)
    {
        if(!root)
            return;
        
        list.push_back(root->val);
        
        preorderTraversalUtil(root->left,list);        
        
        preorderTraversalUtil(root->right,list);        
    }
    
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> list;
        if(!root)
            return list;
        preorderTraversalUtil(root,list);
        return list;
    }
};