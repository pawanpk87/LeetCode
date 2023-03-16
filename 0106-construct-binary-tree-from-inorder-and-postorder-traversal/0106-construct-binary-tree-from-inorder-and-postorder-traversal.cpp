class Solution {
public:
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int postArrayIndex=postorder.size()-1;
        return buildTreeUtill(inorder,postorder,0,postorder.size()-1,postArrayIndex);
    }
    
    TreeNode* buildTreeUtill(vector<int>& inorder, vector<int>& postorder,int left,int right,int& postArrayIndex)
    {
        if(left > right)
        {
            return NULL;
        }
        
        int currIndex=left;
        while(inorder[currIndex]!=postorder[postArrayIndex])
        {
            currIndex++;
        }
        
        postArrayIndex--;
        
        TreeNode* node=new TreeNode(inorder[currIndex]);
        node->right=buildTreeUtill(inorder,postorder,currIndex+1,right,postArrayIndex);
        node->left=buildTreeUtill(inorder,postorder,left,currIndex-1,postArrayIndex);
        
        return node;
    }
    
};