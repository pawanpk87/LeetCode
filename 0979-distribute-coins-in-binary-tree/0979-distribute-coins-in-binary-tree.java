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
    private int moves = 0;
    
    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        moves += Math.abs(left) + Math.abs(right);
        
        return root.val + left + right - 1;
    }
    
    public int distributeCoins(TreeNode root) {
        solve(root);
        return moves;
    }
}