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
    private boolean evaluateTreeUtil(TreeNode root){
        if(root.left == null && root.right == null){
            return root.val == 1 ? true : false;
        }
        boolean left = evaluateTreeUtil(root.left);
        boolean right = evaluateTreeUtil(root.right);
        return root.val == 2 ? left || right : left & right;
    }
    
    public boolean evaluateTree(TreeNode root) {
        if(root == null){
            return false;
        }
        return evaluateTreeUtil(root);
    }
}