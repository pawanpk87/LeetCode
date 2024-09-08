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
    private int prevNum = -1;
    private int minNum = Integer.MAX_VALUE;
    
    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }    
        
        traverse(root.left);
        
        if(prevNum == -1) {
            prevNum = root.val;
        } else {
            minNum = Math.min(minNum, Math.abs(prevNum - root.val));
        }
        
        prevNum = root.val;
        
        traverse(root.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minNum;
    }
}