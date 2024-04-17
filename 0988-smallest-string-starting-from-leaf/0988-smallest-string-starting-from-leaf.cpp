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
    void traverse(TreeNode* root, string currStr, string& resStr){
        if(!root){
            return;
        }
        
        currStr.push_back((root->val + 'a'));
        
        if(!root->left && !root->right){
            reverse(currStr.begin(), currStr.end());
            if(resStr == ""){
                resStr = currStr;
            } else if(resStr > currStr){
                resStr = currStr;
            }
            return;
        }
        
        traverse(root->left, currStr, resStr);
        traverse(root->right, currStr, resStr);
    }
public:
    string smallestFromLeaf(TreeNode* root) {
        string resStr = "", currStr = "";
        traverse(root, currStr, resStr);
        return resStr;
    }
};