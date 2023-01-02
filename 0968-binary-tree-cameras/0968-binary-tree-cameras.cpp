class Solution {
private:
    unordered_set<TreeNode*> covered;
    int camera=0;
    
    void minCameraCoverUtil(TreeNode* root,TreeNode* parent) {
        if(root)
        {
            minCameraCoverUtil(root->left,root);
            minCameraCoverUtil(root->right,root);
            
            if(parent==NULL && covered.find(root) == covered.end() ||
               covered.find(root->left) == covered.end() ||
               covered.find(root->right) == covered.end())
            {
                camera++;
                covered.insert(root);
                covered.insert(parent);
                covered.insert(root->left);
                covered.insert(root->right);
            }
        }
    }
    
public:
    int minCameraCover(TreeNode* root) {
        covered.insert(NULL);
        minCameraCoverUtil(root,NULL);
        return camera;
    }
};