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
    bool isLeave(TreeNode* node){
        if(node == NULL){
            return true;
        }
        return node->left == NULL && node->right == NULL;
    }
    
    int getNum(TreeNode* node){
        if(node == NULL){
            return 0;
        }
        return node->val;
    }
public:
    int sumOfLeftLeaves(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        if(isLeave(root->left)){
            return getNum(root->left) + sumOfLeftLeaves(root->right);
        } else{
            return sumOfLeftLeaves(root->left) + 
                   sumOfLeftLeaves(root->right);
        }
    }
};