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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector <vector<int>>  ans;
        if(!root) return ans;
        queue <TreeNode*> q;
        TreeNode *temp=root;
        q.push(temp);
        bool term=true;
        while(!q.empty())
        {
            int n=q.size();
            vector<int> v;
            while(n)
            {
                temp=q.front();
                q.pop();
                v.push_back(temp->val);
                if(temp->left!=NULL)
                    q.push(temp->left);
                if(temp->right!=NULL)
                    q.push(temp->right);
                n--;
            }
            if(term==true)
            {
                ans.push_back(v);
                term=false;
            }
            else
            {
                reverse(v.begin(),v.end());
                ans.push_back(v);
                term=true;
            }
        }
        return ans;
    }
};