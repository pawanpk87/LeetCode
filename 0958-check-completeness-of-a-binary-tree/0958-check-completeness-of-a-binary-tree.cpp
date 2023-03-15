class Solution {
public:
    bool isCompleteTree(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        bool flag=false;
        while(!q.empty())
        {
            TreeNode* temp=q.front(); q.pop();
            if(temp->left)
            {
                if(flag)
                   return false;
                q.push(temp->left);
            }else{
                flag=true;
            }
            
            if(temp->right)
            {
                if(flag)
                   return false;
                q.push(temp->right);
            }else{
                flag=true;
            }
        }
        return true;
    }
};