class Solution {
private:
    bool isSymmetricUtil(TreeNode* leftRoot,TreeNode* rightRoot){        
        if(leftRoot && rightRoot){
            if(leftRoot->val != rightRoot->val)
                return false;

            return isSymmetricUtil(leftRoot->left,rightRoot->right) && 
                   isSymmetricUtil(leftRoot->right,rightRoot->left);
        }
        else if(!leftRoot && !rightRoot)
            return true;
        else
            return false;
    }
public:
    bool isSymmetric(TreeNode* root) {
        if(!root)
            return false;
        return isSymmetricUtil(root->left,root->right);
    }
};