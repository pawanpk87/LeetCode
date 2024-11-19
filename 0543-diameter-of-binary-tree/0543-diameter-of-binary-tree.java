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
    int maxDiameter = 0;
    
    private int diameterOfBinaryTreeUtil(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftDepth = diameterOfBinaryTreeUtil(root.left);
        int rightDepth = diameterOfBinaryTreeUtil(root.right);
        
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        
        diameterOfBinaryTreeUtil(root);
        
        return maxDiameter;
    }
}