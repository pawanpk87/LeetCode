class Solution {
    TreeNode startNode = null, destNode = null;
    
    private void traverse(TreeNode currNode, TreeNode parentNode, 
                          int startValue, int destValue, 
                          Map<TreeNode, TreeNode> parent) {
        if(currNode != null) {
            if(startValue == currNode.val) {
                startNode = currNode;
            }
            
            if(destValue == currNode.val) {
                destNode = currNode;
            }
            
            parent.put(currNode, parentNode);
            
            traverse(currNode.left, currNode, startValue, destValue, parent);
            traverse(currNode.right, currNode, startValue, destValue, parent);
        }
    }
    
    private TreeNode lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        
        if(root == p) {
            return p;
        }    
        
        if(root == q) {
            return q;
        }
        
        TreeNode leftNode = lowestCommonAncestorUtil(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestorUtil(root.right, p, q);
        
        if(leftNode != null && rightNode != null) {
            return root;
        }
        
        return leftNode != null ? leftNode : rightNode;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        traverse(root, null, startValue, destValue, parent);
    
        TreeNode lca = lowestCommonAncestorUtil(root, startNode, destNode);
        
        String leftPath = getPath(lca, new StringBuilder(), startNode);
        String rightPath = getPath(lca, new StringBuilder(), destNode);
        
        StringBuilder sb = new StringBuilder();
        for(char ch : leftPath.toCharArray()){
            sb.append('U');
        }
        
        return sb.toString() + rightPath;
    }
    
    private String getPath(TreeNode root, StringBuilder currPath, TreeNode targetNode) {
        if(root == null) {
            return null;
        }
        
        if(root == targetNode) {
            return currPath.toString();
        }
        
        currPath.append('L');
        String leftPath = getPath(root.left, currPath, targetNode);
        
        currPath.deleteCharAt(currPath.length() - 1);
        
        currPath.append('R');
        String rightPath = getPath(root.right, currPath, targetNode);
        
        currPath.deleteCharAt(currPath.length() - 1);
        
        return leftPath == null ? rightPath : leftPath;
    }
}