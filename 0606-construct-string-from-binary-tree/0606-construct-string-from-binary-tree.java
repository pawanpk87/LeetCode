class Solution {
    private String tree2strUtil(TreeNode root){
        if(root == null){
            return "()";
        }    
        
        if(root.left == null && root.right == null){
            return "(" + root.val + ")";
        }
        
        String currStr = "(" + root.val;
        
        String leftStr = tree2strUtil(root.left);
        
        currStr += leftStr;
        
        String rightStr = tree2strUtil(root.right);
        
        if(rightStr.length() > 2){
            currStr += rightStr;
        }
        
        return currStr + ")";
    }
    
    public String tree2str(TreeNode root) {
        String resStr = tree2strUtil(root);
        return resStr.substring(1, resStr.length()-1);
    }
}