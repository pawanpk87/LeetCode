/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int prevNum = 0;
    
    private void traverse(TreeNode root){
        if(root == null) {
            return;
        }   
        traverse(root.right);
        root.val = prevNum = root.val + prevNum;
        traverse(root.left);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
}