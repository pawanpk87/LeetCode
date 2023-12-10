class Solution {
    private void inorderTraversalUtil(TreeNode root, List<Integer> inorderTrav){
        if(root != null){
            inorderTraversalUtil(root.left, inorderTrav);
            inorderTrav.add(root.val);
            inorderTraversalUtil(root.right, inorderTrav);
        }    
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTrav = new ArrayList<>();
        inorderTraversalUtil(root, inorderTrav);
        return inorderTrav;
    }
}