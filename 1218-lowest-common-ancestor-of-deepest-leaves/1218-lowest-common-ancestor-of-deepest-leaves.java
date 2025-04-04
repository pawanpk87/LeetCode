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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) {
            return root;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if(leftDepth == rightDepth) {
            return root;
        }

        if(leftDepth < rightDepth) {
            return lcaDeepestLeaves(root.right);
        } else {
            return lcaDeepestLeaves(root.left);
        }
    }

    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(
            depth(root.left),
            depth(root.right)
        );
    }
}