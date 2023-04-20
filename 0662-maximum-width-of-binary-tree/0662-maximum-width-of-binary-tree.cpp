class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        
        queue<pair<TreeNode*,unsigned long long int>> q;
        q.push({root,1});
        int maxWidth=0;
        while(!q.empty())
        {
            int n=q.size();
            unsigned long long int firstIndex=q.front().second;
            unsigned long long int lastIndex;
            while(n--)
            {
                lastIndex=q.front().second;
                TreeNode* node=q.front().first;
                q.pop();
                
                if(node->left)
                    q.push({node->left,2*lastIndex+1});
                if(node->right)
                    q.push({node->right,2*lastIndex+2});
                
            }
            if(maxWidth < lastIndex-firstIndex+1)
            {
              maxWidth = lastIndex-firstIndex+1;
            }
        }
        return maxWidth;
        
    }
};