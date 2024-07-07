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
    int maxPathSumVal = Integer.MIN_VALUE;
    
    private int maxPathSumUtil(TreeNode root){
        if(root != null){
            int leftMaxPathSum = maxPathSumUtil(root.left);
            int rightMaxPathSum = maxPathSumUtil(root.right);
            
            int tempCurrMaxPath = Math.max(Math.max(leftMaxPathSum, rightMaxPathSum) + root.val, root.val);
            
            maxPathSumVal = Math.max(maxPathSumVal, Math.max(tempCurrMaxPath, leftMaxPathSum + root.val + rightMaxPathSum));
            
            return tempCurrMaxPath;
        } else {
            return 0;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxPathSumVal;
    }
}