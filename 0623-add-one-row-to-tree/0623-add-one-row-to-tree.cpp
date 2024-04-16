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
private:
    TreeNode* addOneRowUtil(TreeNode* root, int val, int depth){
        if(!root){
            return root;
        }
        
        TreeNode *left, *right;
        
        if(depth == 1){
            left = new TreeNode(val);
            right = new TreeNode(val);
            
            left->left = root->left;
            right->right = root->right;
        } else{
            left = addOneRowUtil(root->left, val, depth - 1);
            right = addOneRowUtil(root->right, val, depth - 1);
        }
        
        root->left = left;
        root->right = right;
        
        return root;
    }
public:
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(depth == 1){
            TreeNode* newRoot = new TreeNode(val);
            newRoot->left = root;
            return newRoot;
        }
        return addOneRowUtil(root, val, depth-1);
    }
};